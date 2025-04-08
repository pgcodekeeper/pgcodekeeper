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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.text.MessageFormat;
import java.util.Arrays;

import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ChExpressionAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_policy_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.ExprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Policy_actionContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChPolicy;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public class CreateChPolicy extends ChParserAbstract {

    private static final String POLICY_NAME = "{0} ON {1}";

    private Create_policy_stmtContext ctx;

    public CreateChPolicy(Create_policy_stmtContext ctx, ChDatabase db, ISettings settings) {
        super(db, settings);
        this.ctx = ctx;
    }


    @Override
    public void parseObject() {
        for (var fullNameCtx : ctx.policy_name()) {
            for (var tableNameCtx : fullNameCtx.qualified_name_or_asterisk()) {
                String parentName = getFullCtxText(tableNameCtx);
                for (var policyNameCtx : fullNameCtx.identifier()) {
                    String shortName = getFullCtxText(policyNameCtx);
                    ChPolicy policy = new ChPolicy(MessageFormat.format(POLICY_NAME, shortName, parentName));
                    ctx.policy_action().forEach(e -> parsePolicyOption(policy, e));
                    addSafe(db, policy, Arrays.asList(tableNameCtx, policyNameCtx));
                }
            }
        }
    }

    private void parsePolicyOption(ChPolicy policy, Policy_actionContext actionCtx) {
        if (actionCtx.RESTRICTIVE() != null) {
            policy.setPermissive(false);
            return;
        }

        ExprContext using = actionCtx.expr();
        if (using != null) {
            policy.setUsing(getFullCtxText(using));
            db.addAnalysisLauncher(new ChExpressionAnalysisLauncher(policy, using, fileName));
            return;
        }

        addRoles(actionCtx.users(), policy, ChPolicy::addRole, ChPolicy::addExcept, "ALL");
    }


    @Override
    protected String getStmtAction() {
        return "CREATE POLICY";
    }
}
