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

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alter_policy_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alter_role_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alter_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alter_user_stmtContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;

public class AlterChOther extends ChParserAbstract {

    private final Alter_stmtContext ctx;

    public AlterChOther(Alter_stmtContext ctx, ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        var alterPolicyCtx = ctx.alter_policy_stmt();
        var alterUserCtx = ctx.alter_user_stmt();
        var alterRoleCtx = ctx.alter_role_stmt();
        if (alterPolicyCtx != null) {
            alterPolicy(alterPolicyCtx);
        } else if (alterUserCtx != null) {
            alterUser(alterUserCtx);
        }  else if (alterRoleCtx != null) {
            alterRole(alterRoleCtx);
        }
    }

    private void alterPolicy(Alter_policy_stmtContext ctx) {
        for (var polName : ctx.policy_name()) {
            for (var tableNameCtx : polName.qualified_name_or_asterisk()) {
                for (var policyNameCtx : polName.identifier()) {
                    addObjReference(Arrays.asList(tableNameCtx, policyNameCtx), DbObjType.POLICY, ACTION_ALTER);
                }
            }
        }
    }

    private void alterUser(Alter_user_stmtContext ctx) {
        for (var userNameCtx : ctx.name_with_cluster()) {
            addObjReference(Arrays.asList(userNameCtx.identifier()), DbObjType.USER, ACTION_ALTER);
        }
    }

    private void alterRole(Alter_role_stmtContext ctx) {
        for (var roleCtx : ctx.name_with_cluster()) {
            addObjReference(Arrays.asList(roleCtx.identifier()), DbObjType.ROLE, ACTION_ALTER);
        }
    }

    @Override
    protected String getStmtAction() {
        if (ctx.alter_policy_stmt() != null) {
            return "ALTER POLICY";
        }
        if (ctx.alter_user_stmt() != null) {
            return "ALTER USER";
        }
        if (ctx.alter_role_stmt() != null) {
            return "ALTER ROLE";
        }
        return null;
    }
}
