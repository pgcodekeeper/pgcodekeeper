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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgFtsConfiguration;

public class FtsConfigurationsReader extends JdbcReader {

    public FtsConfigurationsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FTS_CONFIGURATIONS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String name = res.getString("cfgname");
        PgFtsConfiguration config = new PgFtsConfiguration(name);

        String parserSchema = res.getString("prsnspname");
        String parserName = res.getString("prsname");
        config.setParser(PgDiffUtils.getQuotedName(parserSchema) + '.' + PgDiffUtils.getQuotedName(parserName));
        if (!Utils.isPgSystemSchema(parserSchema)) {
            config.addDep(new GenericColumn(parserSchema, parserName, DbObjType.FTS_PARSER));
        }

        String[] fragments = getColArray(res, "tokennames");
        String[] dictSchemas = getColArray(res, "dictschemas");
        String[] dictionaries = getColArray(res, "dictnames");

        if (fragments != null) {
            Map<String, List<String>> dictMap = new HashMap<>();

            for (int i = 0; i < fragments.length; i ++) {
                String fragment = fragments[i];
                String dictSchema = dictSchemas[i];
                String dictName = dictionaries[i];

                StringBuilder sb = new StringBuilder();
                if (!Consts.PG_CATALOG.equals(dictSchema)) {
                    config.addDep(new GenericColumn(dictSchema, dictName, DbObjType.FTS_DICTIONARY));
                    sb.append(PgDiffUtils.getQuotedName(dictSchema) + '.');
                }

                sb.append(PgDiffUtils.getQuotedName(dictName));

                dictMap.computeIfAbsent(fragment, k -> new ArrayList<>()).add(sb.toString());
            }

            dictMap.forEach(config::addDictionary);
        }

        loader.setOwner(config, res.getLong("cfgowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            config.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setAuthor(config, res);
        schema.addFtsConfiguration(config);
    }

    @Override
    protected String getClassId() {
        return "pg_ts_config";
    }
}
