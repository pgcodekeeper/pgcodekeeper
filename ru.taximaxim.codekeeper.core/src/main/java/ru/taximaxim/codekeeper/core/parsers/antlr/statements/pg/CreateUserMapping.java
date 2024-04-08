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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_user_mapping_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Define_foreign_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Foreign_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.User_mapping_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.User_nameContext;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgUserMapping;

public class CreateUserMapping extends PgParserAbstract {

    private final Create_user_mapping_statementContext ctx;

    public CreateUserMapping(Create_user_mapping_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        User_mapping_nameContext userMapping = ctx.user_mapping_name();
        User_nameContext userName = userMapping.user_name();

        if (userName == null) {
            return;
        }
        String server = userMapping.identifier().getText();

        PgUserMapping usm = new PgUserMapping(userName.getText(), server);
        addDepSafe(usm, Arrays.asList(userMapping.identifier()), DbObjType.SERVER);

        Define_foreign_optionsContext options = ctx.define_foreign_options();
        if (options != null) {
            for (Foreign_optionContext option : options.foreign_option()) {
                fillOptionParams(option.character_string().getText(),
                        option.col_label().getText(), false, usm::addOption);
            }
        }
        addSafe(db, usm, Arrays.asList(userMapping));
    }

    @Override
    protected String getStmtAction() {
        StringBuilder sb = new StringBuilder();
        sb.append(ACTION_CREATE).append(' ').append(DbObjType.USER_MAPPING).append(" ");
        sb.append(getUserMappingName(ctx.user_mapping_name()));
        return sb.toString();
    }
}
