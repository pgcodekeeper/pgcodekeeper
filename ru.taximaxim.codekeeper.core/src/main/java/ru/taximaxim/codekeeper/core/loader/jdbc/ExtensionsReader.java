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

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgExtension;

public class ExtensionsReader extends AbstractStatementReader {

    private final PgDatabase db;

    public ExtensionsReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException {
        String extName = res.getString("extname");
        loader.setCurrentObject(new GenericColumn(extName, DbObjType.EXTENSION));
        PgExtension e = new PgExtension(extName);
        e.setSchema(res.getString("namespace"));
        e.setRelocatable(res.getBoolean("extrelocatable"));
        e.addDep(new GenericColumn(e.getSchema(), DbObjType.SCHEMA));
        loader.setComment(e, res);
        loader.setAuthor(e, res);
        db.addExtension(e);
    }

    @Override
    protected String getClassId() {
        return "pg_extension";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addDescriptionPart(builder);

        builder
        .column("res.extname")
        .column("(SELECT n.nspname FROM pg_catalog.pg_namespace n WHERE res.extnamespace = n.oid) AS namespace")
        .column("res.extrelocatable")
        .from("pg_catalog.pg_extension res");
    }
}
