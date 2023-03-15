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

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_table_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Character_stringContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Column_actionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Define_foreign_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Foreign_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Identity_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Sequence_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Set_def_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Set_statisticsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parametersContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Table_actionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Table_column_definitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractPgTable;
import ru.taximaxim.codekeeper.core.schema.AbstractRegularTable;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgRule;
import ru.taximaxim.codekeeper.core.schema.PgSequence;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.PgTrigger;

public class AlterTable extends TableAbstract {

    private final Alter_table_statementContext ctx;
    private final String tablespace;

    public AlterTable(Alter_table_statementContext ctx, PgDatabase db, String tablespace, CommonTokenStream stream) {
        super(db, stream);
        this.ctx = ctx;
        this.tablespace = tablespace;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        AbstractSchema schema = getSchemaSafe(ids);
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);
        AbstractPgTable tabl = null;

        PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, ACTION_ALTER);

        for (Table_actionContext tablAction : ctx.table_action()) {
            IdentifierContext column = tablAction.column;
            Column_actionContext colAction = tablAction.column_action();

            if (column != null && tablAction.DROP() != null) {
                loc.setWarning(DangerStatement.DROP_COLUMN);
            } else if (colAction != null && colAction.data_type() != null) {
                loc.setWarning(DangerStatement.ALTER_COLUMN);
            }

            if (tablAction.owner_to() != null) {
                IRelation r = getSafe(AbstractSchema::getRelation, schema, nameCtx);
                if (r instanceof PgStatement) {
                    fillOwnerTo(tablAction.owner_to().user_name().identifier(), (PgStatement) r);
                }
                continue;
            }

            // everything else requires a real table, so fail immediately
            tabl = (AbstractPgTable) getSafe(AbstractSchema::getTable, schema, nameCtx);

            if (tablAction.tabl_constraint != null) {
                IdentifierContext conNameCtx = tablAction.tabl_constraint.identifier();
                AbstractConstraint con = parseAlterTableConstraint(tablAction,
                        createTableConstraintBlank(tablAction.tabl_constraint),
                        getSchemaNameSafe(ids), nameCtx.getText(), fileName);

                if (!con.getName().isEmpty()) {
                    addSafe(tabl, con, Arrays.asList(
                            QNameParser.getSchemaNameCtx(ids), nameCtx, conNameCtx));
                } else {
                    doSafe(AbstractPgTable::addConstraint, tabl, con);
                }
            }


            if (tablAction.drop_constraint() != null) {
                addObjReference(Arrays.asList(QNameParser.getSchemaNameCtx(ids), nameCtx,
                        tablAction.drop_constraint().constraint_name),
                        DbObjType.CONSTRAINT, ACTION_DROP);
            }

            if (isRefMode()) {
                continue;
            }

            Table_column_definitionContext def = tablAction.table_column_definition();
            if (def != null) {
                addColumn(def.identifier().getText(), def.data_type(),
                        def.collate_identifier(), def.compression_identifier(), def.constraint_common(),
                        def.define_foreign_options(), tabl, getSchemaNameSafe(ids));
            }

            if (column != null && colAction != null) {
                PgColumn col;
                if (tabl.getInherits().isEmpty()) {
                    col = (PgColumn) getSafe(AbstractTable::getColumn, tabl, column);
                } else {
                    String colName = column.getText();
                    col = (PgColumn) tabl.getColumn(colName);
                    if (col == null) {
                        col = new PgColumn(colName);
                        col.setInherit(true);
                        tabl.addColumn(col);
                    }
                }
                parseColumnAction(schema, col, colAction);
            }

            Schema_qualified_nameContext ind = tablAction.index_name;
            if (ind != null) {
                ParserRuleContext indexName = QNameParser.getFirstNameCtx(getIdentifiers(ind));
                AbstractIndex index = getSafe(AbstractTable::getIndex, tabl, indexName);
                index.setClusterIndex(true);
            }

            if (tablAction.WITHOUT() != null && tablAction.OIDS() != null) {
                tabl.setHasOids(false);
            } else if (tablAction.WITH() != null && tablAction.OIDS() != null) {
                tabl.setHasOids(true);
            }

            if (tablAction.TRIGGER() != null) {
                createTrigger(tabl, tablAction);
            }

            if (tablAction.RULE() != null) {
                createRule(tabl, tablAction);
            }

            if (tablAction.SECURITY() != null && tabl instanceof AbstractRegularTable) {
                AbstractRegularTable regTable = (AbstractRegularTable) tabl;
                // since 9.5 PostgreSQL
                if (tablAction.FORCE() != null) {
                    regTable.setForceSecurity(tablAction.NO() == null);
                } else {
                    regTable.setRowSecurity(tablAction.ENABLE() != null);
                }
            }
        }
    }

    private void parseColumnAction(AbstractSchema schema, PgColumn col,
            Column_actionContext colAction) {
        // column statistics
        Set_statisticsContext statistics = colAction.set_statistics();
        if (statistics != null) {
            col.setStatistics(Integer.valueOf(statistics.signed_number_literal().getText()));
        }

        // column not null constraint
        if (colAction.set != null) {
            col.setNullValue(false);
        }

        // column default
        Set_def_columnContext def = colAction.set_def_column();
        if (def != null) {
            VexContext exp = def.vex();
            col.setDefaultValue(getFullCtxText(exp));
            db.addAnalysisLauncher(new VexAnalysisLauncher(col, exp, fileName));
        }

        // column options
        Storage_parametersContext param = colAction.storage_parameters();
        if (param != null) {
            for (Storage_parameter_optionContext option : param.storage_parameter_option()) {
                VexContext opt = option.vex();
                String value = opt == null ? null : opt.getText();
                fillOptionParams(value, option.storage_parameter_name().getText(), false, col::addOption);
            }
        }

        // foreign options
        Define_foreign_optionsContext fOptions = colAction.define_foreign_options();
        if (fOptions != null) {
            for (Foreign_optionContext option : fOptions.foreign_option()) {
                Character_stringContext opt = option.character_string();
                String value = opt == null ? null : opt.getText();
                fillOptionParams(value, option.col_label().getText(), false, col::addForeignOption);
            }
        }

        // column storage
        Storage_optionContext sOptions = colAction.storage_option();
        if (sOptions != null) {
            col.setStorage(sOptions.getText());
        }

        // since 10 PostgreSQL
        Identity_bodyContext identity = colAction.identity_body();
        if (identity != null) {
            String name = null;
            for (Sequence_bodyContext body : identity.sequence_body()) {
                if (body.NAME() != null) {
                    name = QNameParser.getFirstName(getIdentifiers(body.name));
                }
            }
            PgSequence sequence = new PgSequence(name);
            sequence.setDataType(col.getType());
            CreateSequence.fillSequence(sequence, identity.sequence_body());

            col.setSequence(sequence);
            sequence.setParent(schema);
            col.setIdentityType(identity.ALWAYS() != null ? "ALWAYS" : "BY DEFAULT");
        }
    }

    private void createTrigger(AbstractPgTable tabl, Table_actionContext tablAction) {
        if (tablAction.trigger_name == null) {
            return;
        }

        PgTrigger trigger = (PgTrigger) getSafe(PgStatementContainer::getTrigger, tabl,
                tablAction.trigger_name);
        if (trigger != null) {
            if (tablAction.DISABLE() != null) {
                trigger.setEnabledState("DISABLE");
            } else if (tablAction.ENABLE() != null) {
                if (tablAction.REPLICA() != null) {
                    trigger.setEnabledState("ENABLE REPLICA");
                } else if (tablAction.ALWAYS() != null) {
                    trigger.setEnabledState("ENABLE ALWAYS");
                }
            }
        }
    }

    private void createRule(AbstractPgTable tabl, Table_actionContext tablAction) {
        PgRule rule = getSafe(AbstractTable::getRule, tabl, getIdentifiers(tablAction.rewrite_rule_name).get(0));
        if (rule != null) {
            if (tablAction.DISABLE() != null) {
                rule.setEnabledState("DISABLE");
            } else if (tablAction.ENABLE() != null) {
                if (tablAction.REPLICA() != null) {
                    rule.setEnabledState("ENABLE REPLICA");
                } else if (tablAction.ALWAYS() != null) {
                    rule.setEnabledState("ENABLE ALWAYS");
                }
            }
        }
    }

    public AbstractConstraint parseAlterTableConstraint(Table_actionContext tableAction,
            PgConstraint constrBlank, String schemaName, String tableName, String location) {
        constrBlank.setNotValid(tableAction.not_valid != null);
        processTableConstraintBlank(tableAction.tabl_constraint, constrBlank,
                schemaName, tableName, tablespace, location);
        return constrBlank;
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        for (Table_actionContext tablAction : ((Schema_alterContext) ctx)
                .alter_table_statement().table_action()) {
            IdentifierContext column = tablAction.column;
            Column_actionContext colAction = tablAction.column_action();

            if (column != null && tablAction.DROP() != null) {
                loc.setWarning(DangerStatement.DROP_COLUMN);
            } else if (colAction != null && colAction.data_type() != null) {
                loc.setWarning(DangerStatement.ALTER_COLUMN);
            }
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.TABLE, getIdentifiers(ctx.name));
    }
}
