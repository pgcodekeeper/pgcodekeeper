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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrTask;
import ru.taximaxim.codekeeper.core.parsers.antlr.CustomParserListener;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Alter_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_def_table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_def_table_constraintsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_action_dropContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_constraint_bodyContext;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraint;
import ru.taximaxim.codekeeper.core.schema.ms.MsConstraintPk;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsTrigger;

public class AlterMsTable extends MsTableAbstract {

    private final Alter_tableContext ctx;
    private final Queue<AntlrTask<?>> antlrTasks;
    private List<Object> errors;

    public AlterMsTable(Alter_tableContext ctx, MsDatabase db, List<Object> errors, Queue<AntlrTask<?>> antlrTasks) {
        super(db);
        this.ctx = ctx;
        this.errors = errors;
        this.antlrTasks = antlrTasks;
    }

    @Override
    public void parseObject() {
        IdContext schemaCtx = ctx.name.schema;
        IdContext nameCtx = ctx.name.name;
        List<ParserRuleContext> ids = Arrays.asList(schemaCtx, nameCtx);
        AbstractSchema schema = getSchemaSafe(ids);
        AbstractTable table = getSafe(AbstractSchema::getTable, schema, nameCtx);
        PgObjLocation ref = addObjReference(Arrays.asList(schemaCtx, nameCtx),
                DbObjType.TABLE, ACTION_ALTER);

        Column_def_table_constraintsContext constrs = ctx.column_def_table_constraints();
        if (constrs != null ) {
            addConstraint(constrs, table, schemaCtx, nameCtx);
        } else if (ctx.CONSTRAINT() != null && ctx.ALL() == null) {
            for (IdContext id : ctx.name_list().id()) {
                MsConstraint constr = (MsConstraint) getSafe(AbstractTable::getConstraint, table, id);
                if (ctx.WITH() != null) {
                    doSafe(AbstractConstraint::setNotValid, constr, ctx.nocheck_check != null);
                }
                doSafe(MsConstraint::setDisabled, constr, ctx.nocheck != null);
            }
        } else if (ctx.table_drop != null) {
            for (Table_action_dropContext drop : ctx.table_action_drop()) {
                if (drop.COLUMN() != null) {
                    ref.setWarning(DangerStatement.DROP_COLUMN);
                    break;
                }
            }
        } else if (ctx.column_definition() != null) {
            ref.setWarning(DangerStatement.ALTER_COLUMN);
        } else if (ctx.TRIGGER() != null && ctx.ALL() == null) {
            for (IdContext trigger : ctx.name_list().id()) {
                MsTrigger tr = (MsTrigger) getSafe(AbstractTable::getTrigger, table, trigger);
                doSafe(MsTrigger::setDisable, tr, ctx.ENABLE() == null);
                addObjReference(Arrays.asList(schemaCtx, nameCtx, trigger),
                        DbObjType.TRIGGER, ACTION_ALTER);
            }
        } else if (ctx.CHANGE_TRACKING() != null && ctx.ENABLE() != null && !isRefMode()) {
            AntlrParser.submitAntlrTask(antlrTasks, () -> ctx, altTablCtx -> parseTracked(table, altTablCtx));
        }
    }

    private void parseTracked(AbstractTable table, Alter_tableContext altTablCtx) {
        table.getConstraints().stream()
        .filter(MsConstraintPk.class::isInstance)
        .map(MsConstraintPk.class::cast)
        .findFirst()
        .ifPresentOrElse(e -> e.setTracked(altTablCtx.on_off().ON() != null), () -> {
            var ex = new UnresolvedReferenceException(
                        "To enable change tracking, a table must have a primary key.",
                        altTablCtx.CHANGE_TRACKING().getSymbol());
            errors.add(CustomParserListener.handleUnresolvedReference(ex, fileName));
        });
    }

    private void addConstraint(Column_def_table_constraintsContext constrs, AbstractTable table, IdContext schemaCtx,
            IdContext nameCtx) {
        for (Column_def_table_constraintContext colCtx : constrs.column_def_table_constraint()) {
            Table_constraintContext constrCtx = colCtx.table_constraint();
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
                con.setNotValid(ctx.nocheck_add != null);
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
        if (alterTblCtx.DROP() != null && alterTblCtx.COLUMN() != null) {
            loc.setWarning(DangerStatement.DROP_COLUMN);
        } else if (alterTblCtx.ALTER() != null && alterTblCtx.COLUMN() != null) {
            loc.setWarning(DangerStatement.ALTER_COLUMN);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.TABLE, ctx.name);
    }
}
