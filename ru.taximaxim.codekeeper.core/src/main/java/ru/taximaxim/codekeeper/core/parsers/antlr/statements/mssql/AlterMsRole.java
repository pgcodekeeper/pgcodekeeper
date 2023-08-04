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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Alter_db_roleContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.MsRole;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class AlterMsRole extends ParserAbstract {

    private final Alter_db_roleContext ctx;

    public AlterMsRole(Alter_db_roleContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        MsRole role = getSafe(PgDatabase::getRole, db, ctx.role_name);

        if (ctx.ADD() != null) {
            doSafe(MsRole::addMember, role, ctx.database_principal.getText());
        }

        addObjReference(Arrays.asList(ctx.role_name), DbObjType.ROLE, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_ALTER, DbObjType.ROLE, ctx.role_name);
    }
}
