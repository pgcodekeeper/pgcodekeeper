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

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_role_stmtContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChRole;

public class CreateChRole extends ChParserAbstract {

    private final Create_role_stmtContext ctx;

    public CreateChRole(Create_role_stmtContext ctx, ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        for (var roleNameWithCluster : ctx.name_with_cluster()) {
            var roleNameCtx = roleNameWithCluster.identifier();
            ChRole role = new ChRole(roleNameCtx.getText());
            var storageType = ctx.identifier();
            if (storageType != null) {
                role.setStorageType(storageType.getText());
            }
            addSafe(db, role, Arrays.asList(roleNameCtx));
        }
    }

    @Override
    protected String getStmtAction() {
        return "CREATE ROLE";
    }
}
