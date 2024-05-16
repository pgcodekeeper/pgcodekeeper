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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ch;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_user_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.HostContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChUser;

public class CreateChUser extends ChParserAbstract {

    private final Create_user_stmtContext ctx;

    public CreateChUser(Create_user_stmtContext ctx, ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        for (var userName : ctx.name) {
            ChUser user = new ChUser(ChDiffUtils.getQuotedName(userName.getText()));

            var host = ctx.host();
            if (host != null) {
                addHostType(host, user);
            }

            addRoles(ctx.role, user, ChUser::addDefRole, ChUser::addExceptRole, "ALL");
            addRoles(ctx.grantees, user, ChUser::addGrantee, ChUser::addExGrantee, "ANY");

            var defDb = ctx.database;
            if (defDb != null) {
                user.setDefaultDatabase(defDb.getText());
            }

            addSafe(db, user, Arrays.asList(userName));
        }
    }

    private void addHostType(HostContext host, ChUser user) {
        if (host.ANY() != null) {
            return;
        }
        if (host.NONE() != null) {
            user.addHost("NONE");
            return;
        }
        var hostTypes = host.host_type();
        for (var hostType : hostTypes) {
            if (hostType.LOCAL() != null) {
                user.addHost("LOCAL");
            } else {
                var hostText = hostType.literal().getText();
                if (hostType.NAME() != null) {
                    user.addHost("NAME " + hostText);
                } else if (hostType.REGEXP() != null) {
                    user.addHost("REGEXP " + hostText);
                } else if (hostType.IP() != null) {
                    user.addHost("IP " + hostText);
                } else if (hostType.LIKE() != null) {
                    user.addHost("LIKE " + hostText);
                }
            }
        }
    }

    @Override
    protected String getStmtAction() {
        return "CREATE USER";
    }
}
