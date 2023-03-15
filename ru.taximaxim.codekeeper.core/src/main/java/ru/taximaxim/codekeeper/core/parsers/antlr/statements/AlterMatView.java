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
package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_materialized_view_statementContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class AlterMatView extends ParserAbstract {

    private final Alter_materialized_view_statementContext ctx;
    private final String action;

    public AlterMatView(Alter_materialized_view_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
        this.action = ctx.ALL() != null ? "ALTER MATERIALIZED VIEW ALL" : "ALTER MATERIALIZED";
    }

    @Override
    public void parseObject() {
        if (ctx.ALL() == null) {
            List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());
            addObjReference(ids, DbObjType.VIEW, action);
        } else {
            db.addReference(fileName, new PgObjLocation.Builder()
                    .setAction(action).setCtx(ctx.getParent()).build());
        }
    }

    @Override
    protected String getStmtAction() {
        if (ctx.ALL() != null) {
            return action;
        }
        return getStrForStmtAction(action, DbObjType.VIEW,
                ctx.schema_qualified_name().identifier());
    }
}