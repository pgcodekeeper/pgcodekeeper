/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ConstraintAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.ActionContext;
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
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Index_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.List_of_type_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Names_in_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Nulls_distinctionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Sequence_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_directiveContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_column_definitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_deferrableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_initialy_immedContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_of_type_column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractForeignTable;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintCheck;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintExclude;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintFk;
import ru.taximaxim.codekeeper.core.schema.pg.PgConstraintPk;
import ru.taximaxim.codekeeper.core.schema.pg.PgIndexParamContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgSequence;

public abstract class TableAbstract extends PgParserAbstract {

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
        String colName = col.getName();

        VexContext def = body.default_expr;
        if (def != null) {
            col.setDefaultValue(getExpressionText(def, stream));
            db.addAnalysisLauncher(new VexAnalysisLauncher(col, def, fileName));
        } else if (body.NULL() != null) {
            col.setNullValue(body.NOT() == null);
        } else if (body.REFERENCES() != null) {
            IdentifierContext id = ctx.identifier();
            String constrName = id == null ? table.getName() + '_' + colName + "_fkey" : id.getText();
            constr = new PgConstraintFk(constrName);
            fillConstrFk((PgConstraintFk) constr, body, colName, schemaName, table.getName());
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
            constr = new PgConstraintPk(constrName, body.PRIMARY() != null);
            fillConstrPk((PgConstraintPk) constr, body, col, colName, schemaName, table.getName());
        } else if (body.CHECK() != null) {
            IdentifierContext id = ctx.identifier();
            String constrName;
            if (id != null) {
                constrName = id.getText();
            } else {
                constrName = table.getName() + '_' + colName + "_check";
            }
            constr = new PgConstraintCheck(constrName);
            fillConstrCheck((PgConstraintCheck) constr, body, true);
            VexContext expCtx = body.expression;
            db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constr, expCtx, fileName));
        } else if (body.identity_body() != null) {
            Identity_bodyContext identity = body.identity_body();
            String name = table.getName() + '_' + colName + "_seq";
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
            appendConstrCommon(ctx, constr);
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
                addColumn(column.identifier().getText(), column.data_type(), column.storage_option(),
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

    protected void addColumn(String columnName, Data_typeContext datatype, Storage_optionContext storage,
            Collate_identifierContext collate, Compression_identifierContext compression,
            List<Constraint_commonContext> constraints, Encoding_identifierContext encOptions,
            Define_foreign_optionsContext options, AbstractTable table, String schemaName) {
        PgColumn col = new PgColumn(columnName);
        if (datatype != null) {
            col.setType(getTypeName(datatype));
            addTypeDepcy(datatype, col);
        }
        if (storage != null) {
            col.setStorage(storage.getText());
        }
        if (compression != null && compression.compression_method != null) {
            col.setCompression(compression.compression_method.getText());
        }
        if (collate != null) {
            col.setCollation(getFullCtxText(collate.collation));
            addDepSafe(col, getIdentifiers(collate.collation), DbObjType.COLLATION);
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
        addColumn(columnName, null, null, null, null, constraints, null, null, table, schemaName);
    }

    protected void addInherit(AbstractPgTable table, List<ParserRuleContext> idsInh) {
        String inhSchemaName = getSchemaNameSafe(idsInh);
        String inhTableName = QNameParser.getFirstName(idsInh);
        table.addInherits(inhSchemaName, inhTableName);
        addDepSafe(table, idsInh, DbObjType.TABLE);
    }

    protected static PgConstraint createTableConstraintBlank(Constraint_commonContext ctx) {
        IdentifierContext id = ctx.identifier();
        String constrName = id == null ? "" : id.getText();

        var body = ctx.constr_body();
        if (body.PRIMARY() != null || body.UNIQUE() != null) {
            return new PgConstraintPk(constrName, body.PRIMARY() != null);
        }
        if (body.FOREIGN() != null) {
            return new PgConstraintFk(constrName);
        }
        if (body.EXCLUDE() != null) {
            return new PgConstraintExclude(constrName);
        }
        if (body.CHECK() != null) {
            return new PgConstraintCheck(constrName);
        }

        throw new IllegalArgumentException("Unsupportes constraint's type");
    }

    protected void processTableConstraintBlank(Constraint_commonContext ctx,
            PgConstraint constrBlank, String schemaName, String tableName,
            String tablespace, String location) {
        Constr_bodyContext constrBody = ctx.constr_body();

        if (constrBlank instanceof PgConstraintFk) {
            fillConstrFk((PgConstraintFk) constrBlank, constrBody, null, schemaName, tableName);
        } else if (constrBlank instanceof PgConstraintExclude) {
            fillConstrExcl((PgConstraintExclude) constrBlank, constrBody, schemaName, tableName);
            for (Index_columnContext col : constrBody.index_column()) {
                db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constrBlank, col.vex(), location));
                Storage_parametersContext params = col.storage_parameters();
                if (params != null) {
                    for (Storage_parameter_optionContext o : params.storage_parameter_option()) {
                        db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constrBlank, o.vex(), location));
                    }
                }
            }
        } else if (constrBlank instanceof PgConstraintPk) {
            fillConstrPk((PgConstraintPk) constrBlank, constrBody, null, null, schemaName, tableName);
        } else if (constrBlank instanceof PgConstraintCheck) {
            fillConstrCheck((PgConstraintCheck) constrBlank, constrBody, false);
        }

        if (tablespace != null) {
            Index_parametersContext param = constrBody.index_parameters();
            if (param == null || param.USING() == null) {
                ((PgIndexParamContainer) constrBlank).setTablespace(tablespace);
            }
        }

        appendConstrCommon(ctx, constrBlank);
        constrBlank.setNotValid(ctx.VALID() != null);

        VexContext exp = constrBody.vex();
        if (exp != null) {
            db.addAnalysisLauncher(new ConstraintAnalysisLauncher(constrBlank, exp, location));
        }
    }

    private void fillConstrFk(PgConstraintFk constrFk, Constr_bodyContext body, String columnName, String schemaName,
            String tableName) {
        Schema_qualified_nameContext tblRef = body.schema_qualified_name();
        List<ParserRuleContext> ids = getIdentifiers(tblRef);

        String refSchemaName = QNameParser.getSchemaName(ids);
        if (refSchemaName == null && columnName != null) {
            return;
        }

        String refTableName = QNameParser.getFirstName(ids);

        PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);
        GenericColumn fTable = loc.getObj();
        constrFk.setForeignSchema(refSchemaName);
        constrFk.setForeignTable(refTableName);
        constrFk.addDep(fTable);

        if (columnName != null) {
            constrFk.addColumn(columnName);
            constrFk.addDep(new GenericColumn(schemaName, tableName, columnName, DbObjType.COLUMN));
        } else if (body.col != null) {
            for (Schema_qualified_nameContext name : body.col.names_references().schema_qualified_name()) {
                String colName = QNameParser.getFirstName(getIdentifiers(name));
                constrFk.addDep(new GenericColumn(schemaName, tableName, colName, DbObjType.COLUMN));
                constrFk.addColumn(colName);
            }
        }

        Names_in_parensContext refs = body.ref;
        if (refs != null) {
            List<Schema_qualified_nameContext> columns = refs.names_references().schema_qualified_name();
            if (columnName != null && columns.size() != 1) {
                throw new UnresolvedReferenceException(
                        "The number of columns in the source and the key assignment does not match", tblRef.start);
            }

            for (Schema_qualified_nameContext column : columns) {
                var fColumn = QNameParser.getFirstName(getIdentifiers(column));
                constrFk.addForeignColumn(fColumn);
                constrFk.addDep(new GenericColumn(refSchemaName, refTableName, fColumn, DbObjType.COLUMN));
            }
        }

        if (body.FULL() != null) {
            constrFk.setMatch("FULL");
        } else if (body.SIMPLE() != null) {
            constrFk.setMatch("SIMPLE");
        }

        for (var chAct : body.changed_action()) {
            var action = chAct.action();
            if (chAct.DELETE() != null) {
                constrFk.setDelAction(getAction(action));
                var columns = action.col;
                if (columns != null) {
                    for (var column : columns.names_references().schema_qualified_name()) {
                        constrFk.addDelActCol(QNameParser.getFirstName(getIdentifiers(column)));
                    }
                }
            } else {
                constrFk.setUpdAction(getAction(action));
            }
        }
    }

    private void fillConstrPk(PgConstraintPk constrPk, Constr_bodyContext body, PgColumn col, String colName,
            String schemaName, String tableName) {
        if (body.PRIMARY() != null) {
            if (col != null) {
                col.setNullValue(false);
            }
        } else {
            Nulls_distinctionContext dist = body.nulls_distinction();
            constrPk.setDistinct(dist != null && dist.NOT() != null);
        }

        if (colName != null) {
            constrPk.addColumn(colName);
            constrPk.addDep(new GenericColumn(schemaName, tableName, colName, DbObjType.COLUMN));
        } else {
            for (Schema_qualified_nameContext name : body.col.names_references().schema_qualified_name()) {
                String columnName = QNameParser.getFirstName(getIdentifiers(name));
                constrPk.addDep(new GenericColumn(schemaName, tableName, columnName, DbObjType.COLUMN));
                constrPk.addColumn(columnName);
            }
        }

        fillParam(constrPk, body.index_parameters(), schemaName, tableName);
    }

    private void fillConstrCheck(PgConstraintCheck constrCheck, Constr_bodyContext constrBody, boolean isNeedParens) {
        var sb = new StringBuilder();
        sb.append(isNeedParens ? "(" : "")
        .append(getFullCtxText(constrBody.expression))
        .append(isNeedParens ? ")" : "");
        constrCheck.setExpression(sb.toString());
        constrCheck.setInherit(constrBody.INHERIT() == null);
    }

    private void fillConstrExcl(PgConstraintExclude constrExcl, Constr_bodyContext body, String schemaName,
            String tableName) {
        if (body.index_method != null) {
            constrExcl.setIndexMethod(body.index_method.getText());
        }
        fillSimpleColumns(constrExcl, body.index_column(), body.all_op());
        fillParam(constrExcl, body.index_parameters(), schemaName, tableName);
        if (body.where != null) {
            constrExcl.setPredicate(getFullCtxText(body.exp));
        }
    }

    private void fillParam(PgIndexParamContainer constr, Index_parametersContext parameters, String schemaName,
            String tableName) {
        if (parameters.including_index() != null) {
            fillIncludingDepcy(parameters.including_index(), (PgStatement) constr, schemaName, tableName);
            for (var incl : parameters.including_index().identifier()) {
                constr.addInclude(incl.getText());
            }
        }
        if (parameters.with_storage_parameter() != null) {
            var stParams = parameters.with_storage_parameter();
            if (stParams != null && !stParams.isEmpty()) {
                for (var stParam : stParams.storage_parameters().storage_parameter_option()) {
                    var value = stParam.vex();
                    constr.addParam(stParam.storage_parameter_name().getText(), value != null ? value.getText() : null);
                }
            }
        }
        if (parameters.USING() != null) {
            constr.setTablespace(parameters.table_space().identifier().getText());
        }
    }

    private String getAction(ActionContext action) {
        if (action.cascade_restrict() != null) {
            return action.cascade_restrict().CASCADE() != null ? "CASCADE" : "RESTRICT";
        }
        if (action.SET() != null) {
            return action.NULL() != null ? "SET NULL" : "SET DEFAULT";
        }
        return null;
    }

    private static void appendConstrCommon(Constraint_commonContext ctx, PgConstraint constr) {
        Table_deferrableContext defer = ctx.table_deferrable();
        constr.setDeferrable(defer != null && defer.NOT() == null);
        Table_initialy_immedContext init = ctx.table_initialy_immed();
        constr.setInitially(init != null && init.IMMEDIATE() == null);
    }
}
