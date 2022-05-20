package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Compression_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Identity_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_columnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.List_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Names_in_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_deferrableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_initialy_immedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.ConstraintAnalysisLauncher;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import cz.startnet.utils.pgdiff.schema.AbstractForeignTable;
import cz.startnet.utils.pgdiff.schema.AbstractPgTable;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class TableAbstract extends ParserAbstract {
    private final CommonTokenStream stream;

    public TableAbstract(PgDatabase db, CommonTokenStream stream) {
        super(db);
        this.stream = stream;
    }

    protected void fillTypeColumns(List_of_type_column_defContext columns,
            AbstractTable table, String schemaName, String tablespace) {
        if (columns == null) {
            return;
        }
        for (Table_of_type_column_defContext colCtx : columns.table_of_type_column_def()) {
            if (colCtx.tabl_constraint != null) {
                addTableConstraint(colCtx.tabl_constraint, table, schemaName, tablespace);
            } else {
                addColumn(colCtx.identifier().getText(), colCtx.constraint_common(), table, schemaName);
            }
        }
    }

    protected void addTableConstraint(Constraint_commonContext tblConstrCtx,
            AbstractTable table, String schemaName, String tablespace) {
        PgConstraint constrBlank = createTableConstraintBlank(tblConstrCtx);
        processTableConstraintBlank(tblConstrCtx, constrBlank, schemaName,
                table.getName(), tablespace, fileName);
        doSafe(AbstractTable::addConstraint, table, constrBlank);
    }

    private void addTableConstraint(Constraint_commonContext ctx, PgColumn col,
            AbstractTable table, String schemaName) {
        Constr_bodyContext body = ctx.constr_body();
        PgConstraint constr = null;
        StringBuilder definition = null;
        String colName = col.getName();

        VexContext def = body.default_expr;
        if (def != null) {
            col.setDefaultValue(getExpressionText(def, stream));
            db.addAnalysisLauncher(new VexAnalysisLauncher(col, def, fileName));
        } else if (body.NULL() != null) {
            col.setNullValue(body.NOT() == null);
        } else if (body.REFERENCES() != null) {
            Schema_qualified_nameContext tblRef = body.schema_qualified_name();
            List<IdentifierContext> ids = tblRef.identifier();
            String refSchemaName = QNameParser.getSchemaName(ids);
            if (refSchemaName == null) {
                return;
            }
            String refTableName = QNameParser.getFirstName(ids);
            PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);

            GenericColumn ftable = loc.getObj();
            IdentifierContext id = ctx.identifier();
            String constrName = id == null ? table.getName() + '_' + colName + "_fkey" : id.getText();

            constr = new PgConstraint(constrName);
            constr.setForeignTable(ftable);
            constr.addDep(new GenericColumn(schemaName, table.getName(), colName, DbObjType.COLUMN));

            String fColumn = null;

            List<Schema_qualified_nameContext> colNames = body.ref.names_references().schema_qualified_name();
            if (colNames.size() == 1) {
                fColumn = getFullCtxText(colNames.get(0));
            } else {
                throw new UnresolvedReferenceException(
                        "The number of columns in the source and the key assignment does not match",
                        tblRef.start);
            }

            constr.addDep(ftable);
            constr.addForeignColumn(fColumn);
            constr.addDep(new GenericColumn(refSchemaName, refTableName, colName, DbObjType.COLUMN));
            definition = new StringBuilder()
                    .append("FOREIGN KEY (")
                    .append(PgDiffUtils.getQuotedName(colName))
                    .append(") ")
                    .append(getFullCtxText(body));
        } else if (body.UNIQUE() != null || body.PRIMARY() != null) {
            IdentifierContext id = ctx.identifier();
            String constrName;
            if (id != null) {
                constrName = id.getText();
            } else if (body.PRIMARY() != null) {
                constrName = table.getName() + "_pkey";
            } else {
                constrName = table.getName() + '_' + colName + "_key";
            }
            constr = new PgConstraint(constrName);

            if (body.PRIMARY() != null) {
                constr.setUnique(false);
                constr.setPrimaryKey(true);
                col.setNullValue(false);
                definition = new StringBuilder()
                        .append("PRIMARY KEY (")
                        .append(PgDiffUtils.getQuotedName(colName))
                        .append(')');
            } else {
                constr.setUnique(true);
                constr.setPrimaryKey(false);
                definition = new StringBuilder()
                        .append("UNIQUE (")
                        .append(PgDiffUtils.getQuotedName(colName))
                        .append(')');
            }

            constr.addColumn(colName);
            constr.addDep(new GenericColumn(schemaName, table.getName(), colName, DbObjType.COLUMN));
        } else if (body.CHECK() != null) {
            IdentifierContext id = ctx.identifier();
            String constrName;
            if (id != null) {
                constrName = id.getText();
            } else {
                constrName = table.getName() + '_' + col.getName() + "_check";
            }
            constr = new PgConstraint(constrName);
            VexContext expCtx = body.expression;
            definition = new StringBuilder()
                    .append("CHECK ((")
                    .append(getFullCtxText(expCtx))
                    .append("))");
            db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constr, expCtx, fileName));
        } else if (body.identity_body() != null) {
            Identity_bodyContext identity = body.identity_body();

            String name = table.getName() + '_' + col.getName() + "_seq";
            for (Sequence_bodyContext bodyCtx : identity.sequence_body()) {
                if (bodyCtx.NAME() != null) {
                    name = QNameParser.getFirstName(bodyCtx.name.identifier());
                }
            }
            PgSequence sequence = new PgSequence(name);
            sequence.setDataType(col.getType());
            CreateSequence.fillSequence(sequence, identity.sequence_body());

            col.setSequence(sequence);
            col.setIdentityType(identity.ALWAYS() != null ? "ALWAYS" : "BY DEFAULT");
        } else if (body.GENERATED() != null) {
            col.setGenerated(true);
            VexContext genExpr = body.vex();
            col.setDefaultValue(getExpressionText(genExpr, stream));
            db.addAnalysisLauncher(new VexAnalysisLauncher(col, genExpr, fileName));
        }

        if (constr != null) {
            appendConstrCommon(definition, ctx);
            constr.setDefinition(definition.toString());
            table.addConstraint(constr);
        }
    }

    protected void fillColumns(Define_columnsContext columnsCtx, AbstractPgTable table,
            String schemaName, String tablespace) {
        for (Table_column_defContext colCtx : columnsCtx.table_column_def()) {
            if (colCtx.tabl_constraint != null) {
                addTableConstraint(colCtx.tabl_constraint, table, schemaName, tablespace);
            } else if (colCtx.table_column_definition() != null) {
                Table_column_definitionContext column = colCtx.table_column_definition();
                addColumn(column.identifier().getText(), column.data_type(),
                        column.collate_identifier(), column.compression_identifier(),
                        column.constraint_common(),
                        column.define_foreign_options(), table, schemaName);
            }
        }

        Names_in_parensContext parentTable = columnsCtx.names_in_parens();
        if (parentTable != null) {
            for (Schema_qualified_nameContext nameInher : parentTable.names_references().schema_qualified_name()) {
                addInherit(table, nameInher.identifier());
            }
        }
    }

    protected void addColumn(String columnName, Data_typeContext datatype,
            Collate_identifierContext collate, Compression_identifierContext compression,
            List<Constraint_commonContext> constraints,
            Define_foreign_optionsContext options, AbstractTable table, String schemaName) {
        PgColumn col = new PgColumn(columnName);
        if (datatype != null) {
            col.setType(getTypeName(datatype));
            addPgTypeDepcy(datatype, col);
        }
        if (compression != null && compression.compression_method != null) {
            col.setCompression(compression.compression_method.getText());
        }
        if (collate != null) {
            col.setCollation(getFullCtxText(collate.collation));
        }
        for (Constraint_commonContext column_constraint : constraints) {
            addTableConstraint(column_constraint, col, table, schemaName);
        }
        if (options != null) {
            if (table instanceof AbstractForeignTable) {
                for (Foreign_optionContext option : options.foreign_option()) {
                    Character_stringContext opt = option.character_string();
                    String value = opt == null ? "" : opt.getText();
                    fillOptionParams(value, option.col_label().getText(), false, col::addForeignOption);
                }
            } else {
                //throw new IllegalStateException("Options used only for foreign table");
            }
        }
        doSafe(AbstractTable::addColumn, table, col);
    }

    protected void addColumn(String columnName, List<Constraint_commonContext> constraints,
            AbstractTable table, String schemaName) {
        addColumn(columnName, null, null, null, constraints, null, table, schemaName);
    }

    protected void addInherit(AbstractPgTable table, List<IdentifierContext> idsInh) {
        String inhSchemaName = getSchemaNameSafe(idsInh);
        String inhTableName = QNameParser.getFirstName(idsInh);
        table.addInherits(inhSchemaName, inhTableName);
        addDepSafe(table, idsInh, DbObjType.TABLE, table.isPostgres());
    }

    protected static PgConstraint createTableConstraintBlank(Constraint_commonContext ctx) {
        IdentifierContext id = ctx.identifier();
        String constrName = id == null ? "" : id.getText();
        return new PgConstraint(constrName);
    }

    protected void processTableConstraintBlank(Constraint_commonContext ctx,
            PgConstraint constrBlank, String schemaName, String tableName,
            String tablespace, String location) {
        Constr_bodyContext constrBody = ctx.constr_body();

        if (constrBody.REFERENCES() != null) {
            Schema_qualified_nameContext tblRef = constrBody.schema_qualified_name();

            List<IdentifierContext> ids = tblRef.identifier();
            String refTableName = QNameParser.getFirstName(ids);
            String refSchemaName = QNameParser.getSchemaName(ids);

            PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);
            GenericColumn ftable = loc.getObj();

            constrBlank.setForeignTable(ftable);
            constrBlank.addDep(ftable);

            Names_in_parensContext refs = constrBody.ref;
            if (refs != null) {
                for (Schema_qualified_nameContext name : refs.names_references().schema_qualified_name()) {
                    String colName = QNameParser.getFirstName(name.identifier());
                    constrBlank.addForeignColumn(colName);
                    constrBlank.addDep(new GenericColumn(refSchemaName, refTableName, colName, DbObjType.COLUMN));
                }
            }
        }

        boolean isUnique = constrBody.UNIQUE() != null;
        boolean isPrimary = constrBody.PRIMARY() != null;
        constrBlank.setUnique(isUnique);
        constrBlank.setPrimaryKey(isPrimary);

        Names_in_parensContext cols = constrBody.col;
        if (cols != null) {
            for (Schema_qualified_nameContext name : cols.names_references().schema_qualified_name()) {
                String colName = QNameParser.getFirstName(name.identifier());
                constrBlank.addDep(new GenericColumn(schemaName, tableName, colName, DbObjType.COLUMN));
                if (isUnique || isPrimary) {
                    constrBlank.addColumn(colName);
                }
            }
        }

        Index_parametersContext indexParams = constrBody.index_parameters();
        if (indexParams != null) {
            Including_indexContext incl = indexParams.including_index();
            if (incl != null) {
                fillIncludingDepcy(incl, constrBlank, schemaName, tableName);
            }
        }

        StringBuilder sb = new StringBuilder();
        String where = null;
        if (constrBody.WHERE() != null) {
            where = getFullCtxText(constrBody.where, constrBody.exp.getStop());
            sb.append(getFullCtxText(constrBody, constrBody.index_parameters()));
        } else {
            sb.append(getFullCtxText(constrBody));
        }

        if (tablespace != null) {
            Index_parametersContext param = constrBody.index_parameters();
            if (param == null || param.USING() == null) {
                sb.append("\n\tUSING INDEX TABLESPACE ").append(tablespace);
            }
        }

        if (where != null) {
            sb.append(' ').append(where);
        }

        appendConstrCommon(sb, ctx);

        constrBlank.setDefinition(sb.toString());

        for (Index_columnContext c : constrBody.index_column()) {
            db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constrBlank, c.vex(), location));

            Storage_parametersContext params = c.storage_parameters();
            if (params != null) {
                for (Storage_parameter_optionContext o : params.storage_parameter_option()) {
                    db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constrBlank, o.vex(), location));
                }
            }
        }

        VexContext exp = constrBody.vex();
        if (exp != null) {
            db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constrBlank, exp, location));
        }
    }

    private static StringBuilder appendConstrCommon(StringBuilder sb, Constraint_commonContext ctx) {
        Table_deferrableContext defer = ctx.table_deferrable();
        if (defer != null) {
            sb.append(' ').append(getFullCtxText(defer));
        }

        Table_initialy_immedContext init = ctx.table_initialy_immed();
        if (init != null) {
            sb.append(' ').append(getFullCtxText(init));
        }
        return sb;
    }
}
