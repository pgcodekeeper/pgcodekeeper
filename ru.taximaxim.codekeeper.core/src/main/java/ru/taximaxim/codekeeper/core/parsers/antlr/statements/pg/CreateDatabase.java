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

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_database_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CreateDatabase extends ParserAbstract {

    private final Create_database_statementContext ctx;

    public CreateDatabase(Create_database_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_CREATE);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.DATABASE, Arrays.asList(ctx.identifier()));
    }
}