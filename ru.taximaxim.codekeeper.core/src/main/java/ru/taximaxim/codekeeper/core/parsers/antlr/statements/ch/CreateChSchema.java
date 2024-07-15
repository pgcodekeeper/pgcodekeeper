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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Create_database_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Engine_exprContext;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChSchema;

public class CreateChSchema extends ChParserAbstract {

    private final Create_database_stmtContext ctx;

    public CreateChSchema(Create_database_stmtContext ctx, ChDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        var nameCtx = ctx.name_with_cluster().identifier();
        var schema = new ChSchema(nameCtx.getText());
        var engine = ctx.engine_expr();
        if (engine != null) {
            schema.setEngine(getEngine(engine));
        }
        var commCtx = ctx.comment_expr();
        if (commCtx != null) {
            schema.setComment(commCtx.STRING_LITERAL().getText());
        }
        addSafe(db, schema, Arrays.asList(nameCtx));
    }

    private String getEngine(Engine_exprContext engine) {
        var engineBody = new StringBuilder();
        engineBody.append(engine.identifier().getText());
        var exprList = engine.expr_list();
        if (exprList != null) {
            engineBody.append("(");
            for (var expr : exprList.expr()) {
                engineBody.append(getFullCtxText(expr)).append(", ");
            }
            engineBody.setLength(engineBody.length() - 2);
            engineBody.append(')');
        }
        return engineBody.toString();
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.DATABASE, ctx.name_with_cluster().identifier());
    }
}