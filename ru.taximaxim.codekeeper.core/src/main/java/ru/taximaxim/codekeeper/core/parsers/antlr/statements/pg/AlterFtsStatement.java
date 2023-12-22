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

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_fts_configurationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_fts_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsConfiguration;

public class AlterFtsStatement extends PgParserAbstract {

    private final Alter_fts_statementContext ctx;

    public AlterFtsStatement(Alter_fts_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);

        DbObjType tt;
        if (ctx.DICTIONARY() != null) {
            tt = DbObjType.FTS_DICTIONARY;
        } else if (ctx.TEMPLATE() != null) {
            tt = DbObjType.FTS_TEMPLATE;
        } else if (ctx.PARSER() != null) {
            tt = DbObjType.FTS_PARSER;
        } else {
            tt = DbObjType.FTS_CONFIGURATION;
        }

        addObjReference(ids, tt, ACTION_ALTER);

        if (tt != DbObjType.FTS_CONFIGURATION) {
            return;
        }

        PgFtsConfiguration config = getSafe(AbstractSchema::getFtsConfiguration,
                getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        Alter_fts_configurationContext afc = ctx.alter_fts_configuration();
        if (afc != null && afc.ADD() != null) {
            for (IdentifierContext type : afc.identifier_list().identifier()) {
                List<String> dics = new ArrayList<>();
                for (Schema_qualified_nameContext dictionary : afc.schema_qualified_name()) {
                    List<ParserRuleContext> dIds = getIdentifiers(dictionary);
                    dics.add(getFullCtxText(dictionary));
                    addDepSafe(config, dIds, DbObjType.FTS_DICTIONARY, DatabaseType.PG);
                }

                doSafe((s,o) -> s.addDictionary(getFullCtxText(type), dics),
                        config, null);
            }
        }
    }

    @Override
    protected String getStmtAction() {
        DbObjType ftsType;
        if (ctx.DICTIONARY() != null) {
            ftsType = DbObjType.FTS_DICTIONARY;
        } else if (ctx.TEMPLATE() != null) {
            ftsType = DbObjType.FTS_TEMPLATE;
        } else if (ctx.PARSER() != null) {
            ftsType = DbObjType.FTS_PARSER;
        } else {
            ftsType = DbObjType.FTS_CONFIGURATION;
        }
        return getStrForStmtAction(ACTION_ALTER, ftsType, getIdentifiers(ctx.name));
    }
}