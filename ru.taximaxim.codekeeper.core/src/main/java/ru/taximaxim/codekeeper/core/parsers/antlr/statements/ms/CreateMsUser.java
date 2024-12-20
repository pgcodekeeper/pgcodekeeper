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

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_userContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.User_loginContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.User_optionContext;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsUser;

public class CreateMsUser extends MsParserAbstract {

    private final Create_userContext ctx;

    public CreateMsUser(Create_userContext ctx, MsDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.user_name;
        MsUser user = new MsUser(nameCtx.getText());
        User_loginContext login = ctx.user_login();
        if (login != null && login.id() != null) {
            user.setLogin(login.id().getText());
        }

        for (User_optionContext option : ctx.user_option()) {
            if (option.schema_name != null) {
                user.setSchema(option.schema_name.getText());
            }
            if (option.DECIMAL() != null) {
                user.setLanguage(option.DECIMAL().getText());
            } else if (option.language_name_or_alias != null) {
                user.setLanguage(MsDiffUtils.quoteName(option.language_name_or_alias.getText()));
            }
            if (option.on_off() != null) {
                user.setAllowEncrypted(option.on_off().ON() != null);
            }
        }

        addSafe(db, user, Arrays.asList(nameCtx));
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.USER, ctx.user_name);
    }
}
