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
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Activator;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public abstract class AbstractJdbcConnector {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractJdbcConnector.class);

    private static final String PG_DRIVER_NAME = "org.postgresql.Driver";
    private static final String MS_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CH_DRIVER_NAME = "com.clickhouse.jdbc.ClickHouseDriver";

    protected static final String URL_START_MS = "jdbc:sqlserver:";
    protected static final String URL_START_PG = "jdbc:postgresql:";
    protected static final String URL_START_CH = "jdbc:clickhouse:";
    protected static final String URL_START_CH_SHORT = "jdbc:ch:";

    protected DatabaseType dbType;

    protected AbstractJdbcConnector(DatabaseType dbType) {
        this.dbType = dbType;
    }

    /**
     * Creates new connection instance with params specified in constructor.<br>
     * It is the caller responsibility to close connection.
     *
     * @return new connection
     * @throws IOException
     *             If driver not found or a database access error occurs
     */
    public Connection getConnection() throws IOException {
        try {
            Class.forName(getDriverName());
            return DriverManager.getConnection(getUrl(), makeProperties());
        } catch (SQLException | ClassNotFoundException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    protected abstract String getUrl();

    protected Properties makeProperties() {
        Properties props = new Properties();
        String coreVer = "unknown";
        BundleContext bctx = Activator.getContext();
        if (bctx != null) {
            coreVer = bctx.getBundle().getVersion().toString();
        }
        props.setProperty("ApplicationName", "pgCodeKeeper core module, Bundle-Version: " + coreVer);
        return props;
    }

    protected String getDriverName() {
        switch (dbType) {
        case PG:
            return PG_DRIVER_NAME;
        case MS:
            return MS_DRIVER_NAME;
        case CH:
            return CH_DRIVER_NAME;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
    }

    public DatabaseType getType() {
        return dbType;
    }

    protected void log(String message) {
        if (message != null) {
            LOG.info(message);
        }
    }
}