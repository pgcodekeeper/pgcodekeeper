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
import java.util.List;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Drop_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class DropChStatement extends ChParserAbstract {

    private final Drop_stmtContext ctx;

    public DropChStatement(Drop_stmtContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.DATABASE() != null) {
            addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_DROP);
        }
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = null;
        List<IdentifierContext> ids = null;
        if (ctx.DATABASE() != null) {
            type = DbObjType.DATABASE;
            ids = Arrays.asList(ctx.identifier());
        }
        return type != null && ids != null ? getStrForStmtAction(ACTION_DROP, type, ids) : null;
    }

}