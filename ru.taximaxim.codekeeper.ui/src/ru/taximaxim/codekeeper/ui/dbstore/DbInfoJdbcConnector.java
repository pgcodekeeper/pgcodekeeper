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
package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.database.base.jdbc.AbstractJdbcConnector;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class DbInfoJdbcConnector extends AbstractJdbcConnector {

    private static final String URL_START_MS = "jdbc:sqlserver:";
    private static final String URL_START_PG = "jdbc:postgresql:";
    private static final String URL_START_CH = "jdbc:clickhouse:";

    private static final String PG_DRIVER_NAME = "org.postgresql.Driver";
    private static final String MS_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CH_DRIVER_NAME = "com.clickhouse.jdbc.ClickHouseDriver";

    private static final String ESTABLISHING_MSG = "Establishing JDBC connection with host:port %s:%s, db name %s, username %s"; // $NON-NLS-1$

    private final DbInfo dbInfo;
    private final int timeoutSeconds;

    public DbInfoJdbcConnector(DbInfo dbInfo) {
        this(dbInfo, 0);
    }

    public DbInfoJdbcConnector(DbInfo dbInfo, int timeoutSeconds) {
        this.dbInfo = dbInfo;
        this.timeoutSeconds = timeoutSeconds;
    }


    @Override
    public Connection getConnection() throws IOException {
        Log.log(Log.LOG_INFO, getMessage());
        Connection con = null;
        // This part of the code solves the problem with finding the right class in the
        // right location and loads ClickHouseDriver in the Equinox driver whitelist.
        // we can try remove this code and remove folder libs when will be resolved
        // https://github.com/ClickHouse/clickhouse-java/issues/905
        if (DatabaseType.CH == dbInfo.getDbType()) {
            try {
                Class.forName(CH_DRIVER_NAME);
                con = DriverManager.getConnection(getUrl(), makeProperties());
            } catch (SQLException | ClassNotFoundException e) {
                throw new IOException(e.getLocalizedMessage(), e);
            }
        } else {
            con = super.getConnection();
        }
        try {
            con.setReadOnly(dbInfo.isReadOnly());
            return con;
        } catch (SQLException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    protected Properties makeProperties() {
        Properties props = super.makeProperties();

        var userName = dbInfo.getDbUser();
        if (!userName.isEmpty()) {
            props.setProperty("user", userName); //$NON-NLS-1$
        }
        var pass = dbInfo.getDbPass();
        if (!pass.isEmpty()) {
            props.setProperty("password", pass); //$NON-NLS-1$
        }

        switch (dbInfo.getDbType()) {
        case PG, MS:
            props.setProperty("loginTimeout", String.valueOf(timeoutSeconds)); //$NON-NLS-1$
            break;
        case CH:
            props.setProperty("connect_timeout", String.valueOf(timeoutSeconds * 1000)); //$NON-NLS-1$
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbInfo.getDbType());
        }

        var properties = dbInfo.getProperties();
        if (properties != null) {
            properties.entrySet().forEach(entry -> props.setProperty(entry.getKey(), entry.getValue()));
        }

        if (DatabaseType.MS != dbInfo.getDbType()) {
            return props;
        }

        if (!isDbNameEscapable()) {
            props.setProperty("databaseName", dbInfo.getDbName()); //$NON-NLS-1$
        }
        var domain = dbInfo.getDomain();
        if (dbInfo.isWinAuth()) {
            props.setProperty("integratedSecurity", "true"); //$NON-NLS-1$ //$NON-NLS-2$
        } else if (domain != null && !"".equals(domain)) { //$NON-NLS-1$
            props.setProperty("authenticationScheme", "NTLM"); //$NON-NLS-1$ //$NON-NLS-2$
            props.setProperty("integratedSecurity", "true"); //$NON-NLS-1$ //$NON-NLS-2$
            props.setProperty("domain", domain); //$NON-NLS-1$
        }
        return props;
    }

    private boolean isDbNameEscapable() {
        return dbInfo.getDbName().indexOf('}') < 0;
    }

    @Override
    protected String getUrl() {
        return switch (dbInfo.getDbType()) {
            case PG -> URL_START_PG + "//" + dbInfo.getDbHost() + ':' + getPort() + '/' + dbInfo.getDbName(); //$NON-NLS-1$
            case MS -> URL_START_MS + "//" + dbInfo.getDbHost() + ':' + getPort() //$NON-NLS-1$
                        + (isDbNameEscapable() ? ";databaseName={" + dbInfo.getDbName() + '}' : ""); //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-2$
            case CH -> URL_START_CH + "//" + dbInfo.getDbHost() + ':' + getPort() //$NON-NLS-1$
                        + (dbInfo.getDbName() != null ? '/' + dbInfo.getDbName() : ""); //$NON-NLS-1$ //$NON-NLS-1$
        };
    }

    private String getPort() {
        var port = dbInfo.getDbPort();
        if (port > 0) {
            return String.valueOf(port);
        }

        return dbInfo.getDbType().getDefaultPort();
    }

    protected String getMessage() {
        return ESTABLISHING_MSG.formatted(dbInfo.getDbHost(), getPort(), dbInfo.getDbName(),
                dbInfo.getDbUser());
    }

    @Override
    protected String getDriverName() {
        return switch (dbInfo.getDbType()) {
            case PG -> PG_DRIVER_NAME;
            case MS -> MS_DRIVER_NAME;
            case CH -> CH_DRIVER_NAME;
        };
    }
}