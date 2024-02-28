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
package ru.taximaxim.codekeeper.core.loader.jdbc.ch;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChSchema;

public class ChSchemasReader extends AbstractStatementReader {

    private final PgDatabase db;

    public ChSchemasReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet result) throws SQLException {
        String schemaName = result.getString("name");
        if (!loader.checkIgnoreSchemaList(schemaName)) {
            return;
        }
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        var schema = new ChSchema(schemaName);
        schema.setEngine(result.getString("engine_full"));
        loader.setComment(schema, result);
        loader.putSchema(schemaName, schema);
        db.addSchema(schema);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        builder
        .column("name")
        .column("engine_full")
        .column("comment AS description")
        .from("system.databases")
        .where("name NOT IN ('INFORMATION_SCHEMA', 'information_schema', 'system')");
    }
}
