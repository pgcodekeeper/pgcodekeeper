package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Column_referencesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constraint_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Foreign_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Identity_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Including_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_parametersContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.List_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sequence_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_deferrableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_initialy_immedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_of_type_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_name_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_with_orderContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_constraint_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractForeignTable;
import cz.startnet.utils.pgdiff.schema.AbstractPgTable;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class TableAbstract extends ParserAbstract {

    public TableAbstract(PgDatabase db) {
        super(db);
    }

    protected void fillTypeColumns(List_of_type_column_defContext columns,
            AbstractTable table, String schemaName, String tablespace) {
        if (columns == null) {
            return;
        }
        for (Table_of_type_column_defContext colCtx : columns.table_col_def) {
            if (colCtx.tabl_constraint != null) {
                addTableConstraint(colCtx.tabl_constraint, table, schemaName, tablespace);
            } else {
                addColumn(colCtx.identifier().getText(), colCtx.constraint_common(), table);
            }
        }
    }

    protected void addTableConstraint(Constraint_commonContext tblConstrCtx,
            AbstractTable table, String schemaName, String tablespace) {
        AbstractConstraint constrBlank = createTableConstraintBlank(tblConstrCtx);
        processTableConstraintBlank(tblConstrCtx, constrBlank, db, schemaName,
                table.getName(), tablespace, isRefMode());
        doSafe(AbstractTable::addConstraint, table, constrBlank);
    }

    private void addTableConstraint(Constraint_commonContext ctx,
            PgColumn col, AbstractTable table) {
        Constr_bodyContext body = ctx.constr_body();
        AbstractConstraint constr = null;
        String colName = col.getName();

        VexContext def = body.default_expr;
        if (def != null) {
            col.setDefaultValue(getFullCtxText(def));
            db.addContextForAnalyze(col, def);
        } else if (body.NULL() != null) {
            col.setNullValue(body.NOT() == null);
        } else if (body.REFERENCES() != null) {
            Schema_qualified_nameContext tblRef = body.schema_qualified_name();
            List<IdentifierContext> ids = tblRef.identifier();
            String refTableName = QNameParser.getFirstName(ids);
            String refSchemaName = QNameParser.getSchemaName(ids);
            if (refSchemaName == null) {
                return;
            }
            GenericColumn ftable = new GenericColumn(refSchemaName, refTableName, DbObjType.TABLE);
            String constrName = ctx.constraint_name == null ?
                    table.getName() + '_' + colName + "_fkey" : ctx.constraint_name.getText();

            constr = new PgConstraint(constrName);
            constr.setForeignTable(ftable);

            String fColumn = null;

            List<Schema_qualified_nameContext> colNames = body.ref.names_references().name;
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
            constr.setDefinition("FOREIGN KEY ("
                    + PgDiffUtils.getQuotedName(colName)
                    + ") REFERENCES " + PgDiffUtils.getQuotedName(ftable.schema)
                    + '.' + PgDiffUtils.getQuotedName(ftable.table)
                    + '(' + PgDiffUtils.getQuotedName(fColumn) +')');
        } else if (body.UNIQUE() != null || body.PRIMARY() != null) {
            String genName = body.PRIMARY() == null ?
                    table.getName() + '_' + colName + "_key"
                    : table.getName() + "_pkey";

            String constrName = ctx.constraint_name == null ? genName : ctx.constraint_name.getText();
            constr = new PgConstraint(constrName);

            if (body.PRIMARY() != null) {
                constr.setUnique(false);
                constr.setPrimaryKey(true);
                constr.setDefinition("PRIMARY KEY (" + PgDiffUtils.getQuotedName(colName) + ')');
                col.setNullValue(false);
            } else {
                constr.setUnique(true);
                constr.setPrimaryKey(false);
                constr.setDefinition("UNIQUE (" + PgDiffUtils.getQuotedName(colName) + ')');
            }

            constr.addColumn(colName);
        } else if (body.CHECK() != null) {
            String genName = table.getName() + '_' + col.getName() + "_check";
            String constrName = ctx.constraint_name == null ? genName : ctx.constraint_name.getText();
            constr = new PgConstraint(constrName);
            VexContext expCtx = body.expression;
            constr.setDefinition("CHECK ((" + getFullCtxText(expCtx) + "))");
            db.addContextForAnalyze(constr, expCtx);
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
        }

        if (constr != null) {
            table.addConstraint(constr);
        }
    }

    protected void fillColumns(Define_columnsContext columnsCtx, AbstractPgTable table,
            String schemaName, String tablespace) {
        for (Table_column_defContext colCtx : columnsCtx.table_col_def) {
            if (colCtx.tabl_constraint != null) {
                addTableConstraint(colCtx.tabl_constraint, table, schemaName, tablespace);
            } else if (colCtx.table_column_definition() != null) {
                Table_column_definitionContext column = colCtx.table_column_definition();
                addColumn(column.column_name.getText(), column.datatype,
                        column.collate_name, column.constraint_common(),
                        column.define_foreign_options(), table);
            }
        }

        Column_referencesContext parentTable = columnsCtx.parent_table;
        if (parentTable != null) {
            for (Schema_qualified_nameContext nameInher : parentTable.names_references().name) {
                addInherit(table, nameInher.identifier());
            }
        }
    }

    protected void addColumn(String columnName, Data_typeContext datatype,
            Collate_identifierContext collate, List<Constraint_commonContext> constraints,
            Define_foreign_optionsContext options, AbstractTable table) {
        PgColumn col = new PgColumn(columnName);
        if (datatype != null) {
            col.setType(getTypeName(datatype));
            addPgTypeDepcy(datatype, col);
        }
        if (collate != null) {
            col.setCollation(getFullCtxText(collate.collation));
        }
        for (Constraint_commonContext column_constraint : constraints) {
            addTableConstraint(column_constraint, col, table);
        }
        if (options != null) {
            if (table instanceof AbstractForeignTable) {
                for (Foreign_optionContext option : options.foreign_option()) {
                    String value = option.value == null ? "" : option.value.getText();
                    fillOptionParams(value, option.name.getText(), false, col::addForeignOption);
                }
            } else {
                //throw new IllegalStateException("Options used only for foreign table");
            }
        }
        doSafe(AbstractTable::addColumn, table, col);
    }

    protected void addColumn(String columnName, List<Constraint_commonContext> constraints,
            AbstractTable table) {
        addColumn(columnName, null, null, constraints, null, table);
    }

    protected void addInherit(AbstractPgTable table, List<IdentifierContext> idsInh) {
        String inhSchemaName = getSchemaNameSafe(idsInh);
        String inhTableName = QNameParser.getFirstName(idsInh);
        table.addInherits(inhSchemaName, inhTableName);
        addDepSafe(table, idsInh, DbObjType.TABLE, table.isPostgres());
    }

    protected static AbstractConstraint createTableConstraintBlank(Constraint_commonContext ctx) {
        String constrName = ctx.constraint_name == null ? "" : ctx.constraint_name.getText();
        return new PgConstraint(constrName);
    }

    protected static void processTableConstraintBlank(Constraint_commonContext ctx,
            AbstractConstraint constrBlank, PgDatabase db, String schemaName,
            String tableName, String tablespace, boolean isRefMode) {
        Constr_bodyContext constrBody = ctx.constr_body();

        if (constrBody.REFERENCES() != null) {
            Schema_qualified_nameContext tblRef = constrBody.schema_qualified_name();

            List<IdentifierContext> ids = tblRef.identifier();
            String refTableName = QNameParser.getFirstName(ids);
            String refSchemaName = QNameParser.getSchemaName(ids);

            if (refSchemaName == null) {
                if (isRefMode) {
                    return;
                }
                throw new UnresolvedReferenceException(SCHEMA_ERROR + getFullCtxText(tblRef),
                        tblRef.start);
            }

            GenericColumn ftable = new GenericColumn(refSchemaName, refTableName, DbObjType.TABLE);
            constrBlank.setForeignTable(ftable);
            constrBlank.addDep(ftable);

            // TODO need ref to table
            Column_referencesContext refs = constrBody.ref;
            if (refs != null) {
                for (Schema_qualified_nameContext name : refs.names_references().name) {
                    String colName = QNameParser.getFirstName(name.identifier());
                    constrBlank.addForeignColumn(colName);
                    constrBlank.addDep(new GenericColumn(refSchemaName, refTableName, colName, DbObjType.COLUMN));
                }
            }
        }

        if (constrBody.UNIQUE() != null || constrBody.PRIMARY() != null) {
            constrBlank.setUnique(constrBody.UNIQUE() != null);
            constrBlank.setPrimaryKey(constrBody.PRIMARY() != null);
            Column_referencesContext cols = constrBody.col;
            if (cols != null) {
                for (Schema_qualified_nameContext name : cols.names_references().name) {
                    constrBlank.addColumn(QNameParser.getFirstName(name.identifier()));
                }
            }
            Including_indexContext incl = constrBody.index_parameters().including_index();
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

        Table_deferrableContext defer = ctx.table_deferrable();
        if (defer != null) {
            sb.append(' ').append(getFullCtxText(defer));
        }

        Table_initialy_immedContext init = ctx.table_initialy_immed();
        if (init != null) {
            sb.append(' ').append(getFullCtxText(init));
        }

        constrBlank.setDefinition(sb.toString());

        VexContext exp = constrBody.vex();
        if (exp != null) {
            db.addContextForAnalyze(constrBlank, exp);
        }
    }

    protected AbstractConstraint getMsConstraint(Table_constraintContext conCtx) {
        String conName = conCtx.id() == null ? "" : conCtx.id().getText();
        AbstractConstraint con = new MsConstraint(conName);

        Table_constraint_bodyContext body = conCtx.table_constraint_body();
        con.setPrimaryKey(body.PRIMARY() != null);
        con.setUnique(body.UNIQUE() != null);

        if (body.REFERENCES() != null) {
            Qualified_nameContext ref = body.qualified_name();
            String fschema = getSchemaNameSafe(Arrays.asList(ref.schema, ref.name));
            String ftable = ref.name.getText();

            GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
            con.setForeignTable(ftableRef);
            con.addDep(ftableRef);

            Column_name_listContext columns = body.pk;
            if (columns != null) {
                for (IdContext column : columns.id()) {
                    String col = column.getText();
                    con.addForeignColumn(col);
                    con.addDep(new GenericColumn(fschema, ftable, col, DbObjType.COLUMN));
                }
            }
        } else if (body.column_name_list_with_order() != null) {
            for (Column_with_orderContext column : body.column_name_list_with_order()
                    .column_with_order()) {
                con.addColumn(column.id().getText());
            }
        }

        con.setDefinition(getFullCtxText(conCtx.table_constraint_body()));
        return con;
    }
}