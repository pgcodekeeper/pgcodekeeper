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

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_fts_template_statementContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgFtsTemplate;

public class CreateFtsTemplate extends ParserAbstract {

    private final Create_fts_template_statementContext ctx;

    public CreateFtsTemplate(Create_fts_template_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        PgFtsTemplate template = new PgFtsTemplate(QNameParser.getFirstName(ids));

        /*
         * function signatures are hardcoded for proper dependency resolution
         * argument list for each type of function is predetermined
         */

        if (ctx.init_name != null) {
            template.setInitFunction(ParserAbstract.getFullCtxText(ctx.init_name));
            addDepSafe(template, getIdentifiers(ctx.init_name), DbObjType.FUNCTION, DatabaseType.PG,
                    "(internal)");
        }

        template.setLexizeFunction(ParserAbstract.getFullCtxText(ctx.lexize_name));
        addDepSafe(template, getIdentifiers(ctx.lexize_name), DbObjType.FUNCTION, DatabaseType.PG,
                "(internal, internal, internal, internal)");

        addSafe(getSchemaSafe(ids), template, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_TEMPLATE, getIdentifiers(ctx.name));
    }
}
