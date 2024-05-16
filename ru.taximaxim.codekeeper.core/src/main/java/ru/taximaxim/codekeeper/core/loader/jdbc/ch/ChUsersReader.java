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

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChUser;

public class ChUsersReader extends AbstractStatementReader {

    private static final String LOCAL = "localhost";
    private static final String IP = "::/0";
    private final ChDatabase db;

    public ChUsersReader(JdbcLoaderBase loader, ChDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException, XmlReaderException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(name, DbObjType.USER));

        ChUser user = new ChUser(name);

        fillHosts(res, user);

        ChJdbcUtils.addRoles(res, "default_roles_list", "default_roles_except", user,
                ChUser::addDefRole, ChUser::addExceptRole);

        ChJdbcUtils.addRoles(res, "grantees_list", "grantees_except", user,
                ChUser::addGrantee, ChUser::addExGrantee);

        var defDb = res.getString("default_database");
        if (!defDb.isBlank()) {
            user.setDefaultDatabase(defDb);
        }
        db.addUser(user);
    }

    private void fillHosts(ResultSet res, ChUser user) throws SQLException {
        boolean isAnyHost = false;

        String[] hostNames = JdbcReader.getColArray(res, "host_names");
        if (hostNames != null) {
            for (String hostName : hostNames) {
                user.addHost(LOCAL.equals(hostName) ? "LOCAL" : "NAME " + ChDiffUtils.quoteLiteralName(hostName));
            }
        }

        String[] hostIps = JdbcReader.getColArray(res, "host_ip");
        if (hostIps != null) {
            for (String ip : hostIps) {
                if (!IP.equals(ip)) {
                    user.addHost("IP " + ChDiffUtils.quoteLiteralName(ip));
                } else {
                    isAnyHost = true;
                }
            }
        }

        String[] hostRegexps = JdbcReader.getColArray(res, "host_names_regexp");
        if (hostRegexps != null) {
            for (String regexp : hostRegexps) {
                user.addHost("REGEXP " + ChDiffUtils.quoteLiteralName(regexp));
            }
        }

        String[] hostLike = JdbcReader.getColArray(res, "host_names_like");
        if (hostLike != null) {
            for (String like : hostLike) {
                user.addHost("LIKE " + ChDiffUtils.quoteLiteralName(like));
            }
        }

        if (!isAnyHost && user.getHosts().isEmpty()) {
            user.addHost("NONE");
        }
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        builder
        .column("name")
        .column("host_ip")
        .column("host_names")
        .column("host_names_regexp")
        .column("host_names_like")
        .column("default_roles_list")
        .column("default_roles_except")
        .column("default_database")
        .column("grantees_list")
        .column("grantees_except")
        .from("system.users");
    }
}
