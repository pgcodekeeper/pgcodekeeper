/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Alter_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_action_dropContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraint_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_elements_extendedContext;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraint;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;
import ru.taximaxim.codekeeper.core.schema.ms.MsTrigger;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class AlterMsTable extends MsTableAbstract {

    private final Alter_tableContext ctx;

    public AlterMsTable(Alter_tableContext ctx, MsDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.name.schema;
        IdContext nameCtx = ctx.name.name;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = getSafe(AbstractSchema::getTable, schema, nameCtx);
        PgObjLocation ref = addObjReference(ids, DbObjType.TABLE, ACTION_ALTER);

        var tableActionCtx = ctx.alter_table_action();
        var elements = tableActionCtx.table_elements_extended();
        if (elements != null) {
            addConstraints(elements, table, schemaCtx, nameCtx);
        } else if (tableActionCtx.CONSTRAINT() != null && tableActionCtx.ALL() == null) {
            for (IdContext id : tableActionCtx.name_list().id()) {
                MsConstraint constr = (MsConstraint) getSafe(AbstractTable::getConstraint, table, id);
                if (tableActionCtx.WITH() != null) {
                    doSafe(AbstractConstraint::setNotValid, constr, tableActionCtx.nocheck_check != null);
                }
                doSafe(MsConstraint::setDisabled, constr, tableActionCtx.nocheck != null);
            }
        } else if (tableActionCtx.table_drop != null) {
            for (Table_action_dropContext drop : tableActionCtx.table_action_drop()) {
                if (drop.COLUMN() != null) {
                    ref.setWarning(DangerStatement.DROP_COLUMN);
                    break;
                }
            }
        } else if (tableActionCtx.column_definition() != null) {
            ref.setWarning(DangerStatement.ALTER_COLUMN);
        } else if (tableActionCtx.TRIGGER() != null && tableActionCtx.ALL() == null) {
            for (IdContext trigger : tableActionCtx.name_list().id()) {
                MsTrigger tr = (MsTrigger) getSafe(AbstractTable::getTrigger, table, trigger);
                doSafe(MsTrigger::setDisable, tr, tableActionCtx.ENABLE() == null);
                addObjReference(Arrays.asList(schemaCtx, nameCtx, trigger),
                        DbObjType.TRIGGER, ACTION_ALTER);
            }
        } else if (tableActionCtx.CHANGE_TRACKING() != null && tableActionCtx.ENABLE() != null) {
            doSafe(MsTable::setTracked, ((MsTable) table), tableActionCtx.on_off().ON() != null);
        } else if (tableActionCtx.SET() != null) {
            var set = tableActionCtx.alter_table_set_action().index_option();
            if (set != null && set.key.getText().equalsIgnoreCase("SYSTEM_VERSIONING")) {
                var sysVer = set.index_option_value();
                if (sysVer.ON() != null) {
                    doSafe(MsTable::setSysVersioning, ((MsTable) table), getFullCtxText(sysVer));
                    addHistTableDep(sysVer.on_option(), table);
                }
            }
        }
    }

    private void addConstraints(Table_elements_extendedContext elementsCtx, AbstractTable table, IdContext schemaCtx,
            IdContext nameCtx) {
        for (var elementCtx : elementsCtx.table_element_extended()) {
            Table_constraintContext constrCtx = elementCtx.table_constraint();
            if (constrCtx == null) {
                continue;
            }

            Table_constraint_bodyContext constrBodyCtx = constrCtx.table_constraint_body();
            if (constrBodyCtx.DEFAULT() != null) {
                MsColumn col = (MsColumn) getSafe(AbstractTable::getColumn, table, constrBodyCtx.id());
                ExpressionContext expCtx = constrBodyCtx.expression();
                doSafe(MsColumn::setDefaultValue, col, getFullCtxTextWithCheckNewLines(expCtx));
                if (constrCtx.constraint != null) {
                    doSafe(MsColumn::setDefaultName, col, constrCtx.constraint.getText());
                }
                db.addAnalysisLauncher(new MsExpressionAnalysisLauncher(col, expCtx, fileName));
            } else {
                AbstractConstraint con = getMsConstraint(constrCtx, schemaCtx.getText(), nameCtx.getText());
                con.setNotValid(ctx.alter_table_action().nocheck_add != null);
                IdContext id = constrCtx.id();
                if (id != null) {
                    addSafe(table, con, Arrays.asList(schemaCtx, nameCtx, id));
                } else {
                    doSafe(AbstractTable::addConstraint, table, con);
                }
            }
        }
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        Alter_tableContext alterTblCtx  = ((Schema_alterContext) ctx).alter_table();
        var tableActionCtx = alterTblCtx.alter_table_action();
        if (tableActionCtx.DROP() != null && tableActionCtx.COLUMN() != null) {
            loc.setWarning(DangerStatement.DROP_COLUMN);
        } else if (tableActionCtx.ALTER() != null && tableActionCtx.COLUMN() != null) {
            loc.setWarning(DangerStatement.ALTER_COLUMN);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.TABLE, ctx.name);
    }
}
