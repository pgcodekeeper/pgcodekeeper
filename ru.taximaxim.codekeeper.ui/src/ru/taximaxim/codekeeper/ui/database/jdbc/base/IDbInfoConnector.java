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
package ru.taximaxim.codekeeper.ui.database.jdbc.base;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.pgcodekeeper.core.database.base.jdbc.IJdbcConnector;

import ru.taximaxim.codekeeper.ui.database.jdbc.ch.ChDbInfoConnector;
import ru.taximaxim.codekeeper.ui.database.jdbc.ms.MsDbInfoConnector;
import ru.taximaxim.codekeeper.ui.database.jdbc.pg.PgDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;

public interface IDbInfoConnector extends IJdbcConnector {

    static final String ESTABLISHING_MSG = "Establishing JDBC connection with %s"; // $NON-NLS-1$

    static IDbInfoConnector createConnector(DbInfo dbInfo) {
        return createConnector(dbInfo, 0);
    }

    static IDbInfoConnector createConnector(DbInfo dbInfo, int timeoutSeconds) {
        return switch (dbInfo.getDbType()) {
        case PG -> new PgDbInfoConnector(dbInfo, timeoutSeconds);
        case MS -> new MsDbInfoConnector(dbInfo, timeoutSeconds);
        case CH -> new ChDbInfoConnector(dbInfo, timeoutSeconds);
        };
    }

    default void makeDefaultDbInfoProps(Properties props, DbInfo dbInfo) {
        var userName = dbInfo.getDbUser();
        if (!userName.isEmpty()) {
            props.setProperty("user", userName); //$NON-NLS-1$
        }
        var pass = dbInfo.getDbPass();
        if (!pass.isEmpty()) {
            props.setProperty("password", pass); //$NON-NLS-1$
        }

        var properties = dbInfo.getProperties();
        if (properties != null) {
            properties.entrySet().forEach(entry -> props.setProperty(entry.getKey(), entry.getValue()));
        }
    }

    default String getMessage(DbInfo dbInfo) {
        return ESTABLISHING_MSG.formatted(dbInfo.getName());
    }

    default void setReadOnly(Connection con, DbInfo dbInfo) throws IOException {
        try {
            con.setReadOnly(dbInfo.isReadOnly());
        } catch (SQLException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }
}