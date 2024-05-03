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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;

public class SchemasReader extends AbstractStatementReader {

    private final PgDatabase db;

    public SchemasReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException {
        String schemaName = res.getString("nspname");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        if (!loader.checkIgnoreSchemaList(schemaName)) {
            return;
        }

        AbstractSchema s = new PgSchema(schemaName);
        long owner = res.getLong("nspowner");

        if (!schemaName.equals(Consts.PUBLIC)) {
            loader.setOwner(s, owner);
            loader.setComment(s, res);
        } else if (!"postgres".equals(loader.getRoleByOid(owner))) {
            loader.setOwner(s, owner);
        }

        loader.setPrivileges(s, res.getString("nspacl"), null);
        loader.setAuthor(s, res);
        loader.putSchema(res.getLong("oid"), s);

        db.addSchema(s);
    }

    @Override
    protected String getClassId() {
        return "pg_namespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        .column("res.oid")
        .column("res.nspname")
        .column("res.nspacl")
        .column("res.nspowner")
        .from("pg_catalog.pg_namespace res")
        .where("res.nspname NOT LIKE 'pg\\_%'")
        .where("res.nspname != 'information_schema'");
    }
}
