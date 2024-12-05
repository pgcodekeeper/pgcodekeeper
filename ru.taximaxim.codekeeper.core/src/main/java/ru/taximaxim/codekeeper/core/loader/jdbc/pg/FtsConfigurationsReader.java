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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgFtsConfiguration;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;

public class FtsConfigurationsReader extends JdbcReader {

    public FtsConfigurationsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String name = res.getString("cfgname");
        PgFtsConfiguration config = new PgFtsConfiguration(name);

        String parserSchema = res.getString("prsnspname");
        String parserName = res.getString("prsname");
        config.setParser(PgDiffUtils.getQuotedName(parserSchema) + '.' + PgDiffUtils.getQuotedName(parserName));
        addDep(config, parserSchema, parserName, DbObjType.FTS_PARSER);

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
        loader.setComment(config, res);
        loader.setAuthor(config, res);
        ((PgSchema) schema).addFtsConfiguration(config);
    }

    @Override
    protected String getClassId() {
        return "pg_ts_config";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.cfgnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);
        addWordsPart(builder);

        builder
        .column("res.cfgname")
        .column("res.cfgowner::bigint")
        .column("p.prsname")
        .column("n.nspname AS prsnspname")
        .from("pg_catalog.pg_ts_config res")
        .join("LEFT JOIN pg_catalog.pg_ts_parser p ON p.oid = res.cfgparser")
        .join("LEFT JOIN pg_catalog.pg_namespace n ON p.prsnamespace = n.oid");
    }

    private void addWordsPart(QueryBuilder builder) {
        QueryBuilder subSelect = new QueryBuilder()
                .column("alias")
                .from("pg_catalog.ts_token_type(res.cfgparser::pg_catalog.oid) AS t")
                .where("t.tokid = m.maptokentype");

        QueryBuilder words = new QueryBuilder()
                .column("m.mapcfg")
                .column("pg_catalog.array_agg(", subSelect, "ORDER BY m.mapseqno) AS tokennames")
                .column("pg_catalog.array_agg(nsp.nspname ORDER BY m.mapseqno) AS dictschemas")
                .column("pg_catalog.array_agg(dict.dictname ORDER BY m.mapseqno) AS dictnames")
                .from("pg_catalog.pg_ts_config_map m")
                .join("LEFT JOIN pg_catalog.pg_ts_dict dict ON m.mapdict = dict.oid")
                .join("LEFT JOIN pg_catalog.pg_namespace nsp ON dict.dictnamespace = nsp.oid")
                .groupBy("m.mapcfg");

        builder.column("words.tokennames");
        builder.column("words.dictschemas");
        builder.column("words.dictnames");
        builder.join("LEFT JOIN LATERAL", words, "words ON words.mapcfg = res.oid");
    }
}
