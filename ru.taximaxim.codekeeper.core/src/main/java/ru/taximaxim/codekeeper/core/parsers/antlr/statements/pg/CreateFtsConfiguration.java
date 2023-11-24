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

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_fts_configuration_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsConfiguration;

public class CreateFtsConfiguration extends ParserAbstract {

    private final Create_fts_configuration_statementContext ctx;

    public CreateFtsConfiguration(Create_fts_configuration_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        String name = QNameParser.getFirstName(ids);
        PgFtsConfiguration config = new PgFtsConfiguration(name);
        if (ctx.parser_name != null) {
            List<ParserRuleContext> parserIds = getIdentifiers(ctx.parser_name);
            config.setParser(ParserAbstract.getFullCtxText(ctx.parser_name));
            addDepSafe(config, parserIds, DbObjType.FTS_PARSER, DatabaseType.PG);
        }
        addSafe(getSchemaSafe(ids), config, ids);
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FTS_CONFIGURATION,
                getIdentifiers(ctx.name));
    }
}
