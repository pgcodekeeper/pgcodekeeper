/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgIndex;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class IndicesReader extends JdbcReader {

    public IndicesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String tableName = res.getString("table_name");
        PgStatementContainer cont = schema.getStatementContainer(tableName);
        if (cont == null) {
            return;
        }
        String schemaName = schema.getName();
        String indexName = res.getString("relname");
        loader.setCurrentObject(new GenericColumn(schemaName, indexName, DbObjType.INDEX));
        PgIndex i = new PgIndex(indexName);

        String tablespace = res.getString("spcname");
        String definition = res.getString("definition");
        checkObjectValidity(definition, DbObjType.INDEX, indexName);
        loader.submitAntlrTask(definition,
                p ->  new Pair<>(p.sql().statement(0).schema_statement().schema_create().create_index_statement().index_rest(),
                        (CommonTokenStream) p.getTokenStream()),
                pair -> CreateIndex.parseIndex(pair.getFirst(), tablespace, schemaName, tableName, i,
                        (PgDatabase) schema.getDatabase(), loader.getCurrentLocation(), pair.getSecond(),
                        loader.getSettings()));
        loader.setAuthor(i, res);
        loader.setComment(i, res);

        i.setClustered(res.getBoolean("indisclustered"));
        i.setUnique(res.getBoolean("indisunique"));

        if (SupportedPgVersion.VERSION_15.isLE(loader.getVersion())) {
            i.setNullsDistinction(res.getBoolean("indnullsnotdistinct"));
        }

        String inhnspname = res.getString("inhnspname");
        if (inhnspname != null) {
            String inhrelname = res.getString("inhrelname");
            i.addInherit(inhnspname, inhrelname);
            addDep(i, inhnspname, inhrelname, DbObjType.INDEX);
        }
        cont.addIndex(i);
    }

    @Override
    protected String getClassId() {
        return "pg_class";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.relnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionSchemasCte(builder);
        addDescriptionPart(builder, true);

        builder
        .column("res.relname")
        .column("clsrel.relname AS table_name")
        .column("ind.indisunique")
        .column("ind.indisclustered")
        .column("t.spcname")
        .column("pg_catalog.pg_get_indexdef(res.oid) AS definition")
        .column("inhns.nspname AS inhnspname")
        .column("inhrel.relname AS inhrelname")
        .from("pg_catalog.pg_class res")
        .join("JOIN pg_catalog.pg_index ind ON res.oid = ind.indexrelid")
        .join("JOIN pg_catalog.pg_class clsrel ON clsrel.oid = ind.indrelid")
        .join("LEFT JOIN pg_catalog.pg_tablespace t ON res.reltablespace = t.oid")
        .join("LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = ind.indexrelid AND cons.contype IN ('p', 'u', 'x')")
        .join("LEFT JOIN pg_catalog.pg_inherits inh ON (inh.inhrelid = ind.indexrelid)")
        .join("LEFT JOIN pg_catalog.pg_class inhrel ON (inh.inhparent = inhrel.oid)")
        .join("LEFT JOIN pg_catalog.pg_namespace inhns ON inhrel.relnamespace = inhns.oid")
        .where("res.relkind IN ('i', 'I')")
        .where("ind.indisprimary = FALSE")
        .where("ind.indisexclusion = FALSE")
        .where("cons.conindid is NULL");

        if (SupportedPgVersion.VERSION_15.isLE(loader.getVersion())) {
            builder.column("ind.indnullsnotdistinct");
        }
    }
}