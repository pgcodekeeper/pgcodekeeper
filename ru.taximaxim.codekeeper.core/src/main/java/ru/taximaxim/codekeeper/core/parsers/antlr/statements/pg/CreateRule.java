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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.RuleAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_rewrite_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Rewrite_commandContext;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.EventType;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgRule;

public class CreateRule extends PgParserAbstract {
    private final Create_rewrite_statementContext ctx;

    public CreateRule(Create_rewrite_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.table_name);
        addObjReference(ids, DbObjType.TABLE, null);

        PgRule rule = new PgRule(ctx.name.getText());
        rule.setEvent(EventType.valueOf(ctx.event.getText().toUpperCase(Locale.ROOT)));
        if (ctx.INSTEAD() != null){
            rule.setInstead(true);
        }

        setConditionAndAddCommands(ctx, rule, db, fileName);

        ParserRuleContext parent = QNameParser.getFirstNameCtx(ids);
        PgStatementContainer cont = getSafe(AbstractSchema::getStatementContainer,
                getSchemaSafe(ids), parent);
        addSafe(cont, rule, Arrays.asList(QNameParser.getSchemaNameCtx(ids), parent, ctx.name));
    }

    public static void setConditionAndAddCommands(Create_rewrite_statementContext ctx,
            PgRule rule, AbstractDatabase db, String location) {
        rule.setCondition((ctx.WHERE() != null) ? getFullCtxText(ctx.vex()) : null);

        // allows to write a common namespace-setup code with no copy-paste for each cmd type
        for (Rewrite_commandContext cmd : ctx.rewrite_command()) {
            rule.addCommand(checkNewLines(getFullCtxText(cmd), db.getArguments()));
        }

        db.addAnalysisLauncher(new RuleAnalysisLauncher(rule, ctx, location));
    }

    @Override
    protected String getStmtAction() {
        List<ParserRuleContext> ids = new ArrayList<>(getIdentifiers(ctx.table_name));
        ids.add(ctx.name);
        return getStrForStmtAction(ACTION_CREATE, DbObjType.RULE, ids);
    }
}

