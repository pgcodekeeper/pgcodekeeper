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

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgUserMapping;

public class UserMappingReader extends AbstractStatementReader {

    private final PgDatabase db;

    public UserMappingReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException {
        String user  = res.getString("username");
        String server = res.getString("servername");
        if (user == null) {
            // https://www.postgresql.org/docs/current/catalog-pg-user-mapping.html
            // zero if the user mapping is public
            user = "PUBLIC";
        }

        PgUserMapping usm = new PgUserMapping(user, server);

        loader.setCurrentObject(new GenericColumn(usm.getName(), DbObjType.USER_MAPPING));
        usm.addDep(new GenericColumn(usm.getServer(), DbObjType.SERVER));

        String[] options = JdbcReader.getColArray(res, "umoptions");
        if (options != null) {
            ParserAbstract.fillOptionParams(options, usm::addOption, false, true, false);
        }

        loader.setAuthor(usm, res);
        db.addUserMapping(usm);
    }

    @Override
    protected String getClassId() {
        return "pg_user_mapping";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);

        builder
        .column("rol.rolname AS username")
        .column("fsrv.srvname AS servername")
        .column("res.umoptions")
        .from("pg_catalog.pg_user_mapping res")
        .join("LEFT JOIN pg_catalog.pg_foreign_server fsrv ON res.umserver = fsrv.oid")
        .join("LEFT JOIN pg_catalog.pg_roles rol ON res.umuser = rol.oid");
    }
}