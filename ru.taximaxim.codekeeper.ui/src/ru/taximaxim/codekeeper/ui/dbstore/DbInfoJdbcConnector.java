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
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.loader.AbstractJdbcConnector;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public final class DbInfoJdbcConnector extends AbstractJdbcConnector {

    private static final String ESTABLISHING_MSG = "Establishing JDBC connection with host:port {0}:{1}, db name {2}, username {3}"; // $NON-NLS-1$

    private final DbInfo dbInfo;
    private final int timeoutSeconds;

    public DbInfoJdbcConnector(DbInfo dbInfo) {
        this(dbInfo, 0);
    }

    public DbInfoJdbcConnector(DbInfo dbInfo, int timeoutSeconds) {
        super(dbInfo.getDbType());
        this.dbInfo = dbInfo;
        this.timeoutSeconds = timeoutSeconds;
    }

    @Override
    public Connection getConnection() throws IOException {
        log(getMessage());
        var con = super.getConnection();
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

        switch (dbType) {
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

        if (DatabaseType.MS != dbType) {
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
        return switch (dbType) {
            case PG -> URL_START_PG + "//" + dbInfo.getDbHost() + ':' + getPort() + '/' + dbInfo.getDbName(); //$NON-NLS-1$
            case MS -> URL_START_MS + "//" + dbInfo.getDbHost() + ':' + getPort() //$NON-NLS-1$
                        + (isDbNameEscapable() ? ";databaseName={" + dbInfo.getDbName() + '}' : ""); //$NON-NLS-1$ //$NON-NLS-1$ //$NON-NLS-2$
            case CH -> URL_START_CH + "//" + dbInfo.getDbHost() + ':' + getPort() //$NON-NLS-1$
                        + (dbInfo.getDbName() != null ? '/' + dbInfo.getDbName() : ""); //$NON-NLS-1$ //$NON-NLS-1$
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
    }

    private String getPort() {
        var port = dbInfo.getDbPort();
        if (port > 0) {
            return String.valueOf(port);
        }

        return dbType.getDefaultPort();
    }

    protected String getMessage() {
        return MessageFormat.format(ESTABLISHING_MSG, dbInfo.getDbHost(), getPort(), dbInfo.getDbName(),
                dbInfo.getDbUser());
    }
}