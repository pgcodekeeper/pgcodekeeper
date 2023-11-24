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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_policy_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.User_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgEventType;
import ru.taximaxim.codekeeper.core.schema.pg.PgPolicy;

public class CreatePolicy extends ParserAbstract {

    private final Create_policy_statementContext ctx;

    public CreatePolicy(Create_policy_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());
        addObjReference(ids, DbObjType.TABLE, null);

        PgPolicy policy = new PgPolicy(ctx.identifier().getText());

        policy.setPermissive(ctx.RESTRICTIVE() == null);

        if (ctx.FOR() != null && ctx.ALL() == null) {
            policy.setEvent(PgEventType.valueOf(ctx.event.getText().toUpperCase(Locale.ROOT)));
        }

        for (User_nameContext role : ctx.user_name()) {
            policy.addRole(getFullCtxText(role));
        }

        VexContext vex = ctx.using;
        if (vex != null) {
            policy.setUsing(getFullCtxText(vex));
            db.addAnalysisLauncher(new VexAnalysisLauncher(policy, vex, fileName));
        }

        vex = ctx.check;
        if (vex != null) {
            policy.setCheck(getFullCtxText(vex));
            db.addAnalysisLauncher(new VexAnalysisLauncher(policy, vex, fileName));
        }

        ParserRuleContext parent = QNameParser.getFirstNameCtx(ids);
        PgStatementContainer cont = getSafe(
                AbstractSchema::getStatementContainer, getSchemaSafe(ids), parent);
        addSafe(cont, policy, Arrays.asList(QNameParser.getSchemaNameCtx(ids), parent, ctx.identifier()));
    }

    @Override
    protected String getStmtAction() {
        List<ParserRuleContext> ids = new ArrayList<>(getIdentifiers(ctx.schema_qualified_name()));
        ids.add(ctx.identifier());
        return getStrForStmtAction(ACTION_CREATE, DbObjType.POLICY, ids);
    }
}