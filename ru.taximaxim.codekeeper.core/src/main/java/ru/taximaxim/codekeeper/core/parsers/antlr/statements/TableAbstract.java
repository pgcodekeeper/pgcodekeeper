/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ConstraintAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Collate_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Compression_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Constr_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Constraint_commonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_foreign_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Encoding_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Foreign_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Identity_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Including_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.List_of_type_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Names_in_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Nulls_distinctionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Sequence_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_directiveContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_column_definitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_deferrableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_initialy_immedContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_of_type_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.AbstractForeignTable;
import ru.taximaxim.codekeeper.core.schema.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgSequence;

public abstract class TableAbstract extends ParserAbstract {

    private final CommonTokenStream stream;

    protected TableAbstract(PgDatabase db, CommonTokenStream stream) {
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
            List<ParserRuleContext> ids = getIdentifiers(tblRef);
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
                definition = new StringBuilder().append("UNIQUE ");
                Nulls_distinctionContext dist = body.nulls_distinction();
                if (dist != null && dist.NOT() != null) {
                    definition.append("NULLS NOT DISTINCT ");
                }
                definition.append('(').append(PgDiffUtils.getQuotedName(colName)).append(')');
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
                    name = QNameParser.getFirstName(getIdentifiers(bodyCtx.name));
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
                        column.constraint_common(), column.encoding_identifier(),
                        column.define_foreign_options(), table, schemaName);
            }
        }

        Names_in_parensContext parentTable = columnsCtx.names_in_parens();
        if (parentTable != null) {
            for (Schema_qualified_nameContext nameInher : parentTable.names_references().schema_qualified_name()) {
                addInherit(table, getIdentifiers(nameInher));
            }
        }
    }

    protected void addColumn(String columnName, Data_typeContext datatype,
            Collate_identifierContext collate, Compression_identifierContext compression,
            List<Constraint_commonContext> constraints, Encoding_identifierContext encOptions,
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
        if (encOptions != null) {
            for (Storage_directiveContext option : encOptions.storage_directive()) {
                if (option.compress_type != null) {
                    col.setCompressType(option.compress_type.getText());
                } else if (option.compress_level != null) {
                    col.setCompressLevel(Integer.parseInt(option.compress_level.getText()));
                } else if (option.block_size != null) {
                    col.setBlockSize(Integer.parseInt(option.block_size.getText()));
                }
            }
        }

        doSafe(AbstractTable::addColumn, table, col);
    }

    protected void addColumn(String columnName, List<Constraint_commonContext> constraints,
            AbstractTable table, String schemaName) {
        addColumn(columnName, null, null, null, constraints, null, null, table, schemaName);
    }

    protected void addInherit(AbstractPgTable table, List<ParserRuleContext> idsInh) {
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

            List<ParserRuleContext> ids = getIdentifiers(tblRef);
            String refTableName = QNameParser.getFirstName(ids);
            String refSchemaName = QNameParser.getSchemaName(ids);

            PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);
            GenericColumn ftable = loc.getObj();

            constrBlank.setForeignTable(ftable);
            constrBlank.addDep(ftable);

            Names_in_parensContext refs = constrBody.ref;
            if (refs != null) {
                for (Schema_qualified_nameContext name : refs.names_references().schema_qualified_name()) {
                    String colName = QNameParser.getFirstName(getIdentifiers(name));
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
                String colName = QNameParser.getFirstName(getIdentifiers(name));
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
        constrBlank.setNotValid(ctx.VALID() != null);
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
