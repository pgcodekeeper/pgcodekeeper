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
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsRole;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class MsRolesReader {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public MsRolesReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        loader.setCurrentOperation("roles query");
        String query = JdbcQueries.QUERY_MS_ROLES.getQuery();
        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                String name = res.getString("name");
                loader.setCurrentObject(new GenericColumn(name, DbObjType.ROLE));

                MsRole role = new MsRole(name);
                loader.setOwner(role, res.getString("owner"));

                for (XmlReader group : XmlReader.readXML(res.getString("groups"))) {
                    role.addMember(group.getString("m"));
                }

                loader.setPrivileges(role, XmlReader.readXML(res.getString("acl")));

                db.addRole(role);
            }
        }
    }
}
