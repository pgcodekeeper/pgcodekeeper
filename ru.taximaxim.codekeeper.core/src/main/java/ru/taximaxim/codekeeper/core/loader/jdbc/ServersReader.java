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

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgServer;

public class ServersReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public ServersReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("server_query");
        String query = JdbcQueries.QUERY_SERVERS.makeQuery(loader, "pg_foreign_server");
        try(ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgServer server = getServer(res);
                db.addServer(server);
                loader.setAuthor(server, res);
            }
        }
    }

    private PgServer getServer(ResultSet res) throws SQLException {
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
        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            srv.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        loader.setOwner(srv, res.getLong("srvowner"));
        loader.setPrivileges(srv, res.getString("srvacl"), null);
        return srv;
    }
}
