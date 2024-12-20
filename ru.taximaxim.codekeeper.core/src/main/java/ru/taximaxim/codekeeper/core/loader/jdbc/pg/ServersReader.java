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

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgServer;

public class ServersReader extends AbstractStatementReader {

    private final PgDatabase db;

    public ServersReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException {
        String srvName = res.getString("srvname");
        loader.setCurrentObject(new GenericColumn(srvName, DbObjType.SERVER));
        PgServer srv = new PgServer(srvName);
        srv.setFdw(res.getString("fdwname"));
        srv.addDep(new GenericColumn(srv.getFdw(), DbObjType.FOREIGN_DATA_WRAPPER));
        String srvType = res.getString("srvtype");
        if (srvType != null) {
            srv.setType(PgDiffUtils.quoteString(srvType));
        }

        String srvVersion = res.getString("srvversion");
        if (srvVersion != null) {
            srv.setVersion(PgDiffUtils.quoteString(srvVersion));
        }

        String[] options = JdbcReader.getColArray(res, "srvoptions");
        if (options != null) {
            ParserAbstract.fillOptionParams(options, srv::addOption, false, true, false);
        }
        loader.setComment(srv, res);
        loader.setOwner(srv, res.getLong("srvowner"));
        loader.setPrivileges(srv, res.getString("srvacl"), null);
        loader.setAuthor(srv, res);
        db.addServer(srv);
    }

    @Override
    protected String getClassId() {
        return "pg_foreign_server";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        .column("res.srvname")
        .column("res.srvtype")
        .column("res.srvversion")
        .column("res.srvacl")
        .column("res.srvoptions")
        .column("res.srvowner")
        .column("fdw.fdwname")
        .from("pg_catalog.pg_foreign_server res")
        .join("LEFT JOIN pg_catalog.pg_foreign_data_wrapper fdw ON res.srvfdw = fdw.oid");
    }
}
