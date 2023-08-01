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
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Activator;
import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.pgpass.PgPass;
import ru.taximaxim.pgpass.PgPassException;

public class JdbcConnector {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcConnector.class);

    private static final String DRIVER_NAME = "org.postgresql.Driver";

    private static final int DEFAULT_PORT = 5432;

    protected String host;
    protected int port;
    protected String user;
    protected String pass;
    protected String dbName;
    protected String url;

    protected Map<String, String> properties;
    protected String timezone;
    protected boolean readOnly;

    /**
     * @throws IllegalArgumentException url isn't valid
     */
    public static String dbNameFromUrl(String url) {
        return fromUrl(url).dbName;
    }

    public static JdbcConnector fromUrl(String url) {
        return fromUrl(url, Consts.UTC);
    }
    /**
     * @throws IllegalArgumentException url isn't valid
     */
    public static JdbcConnector fromUrl(String url, String timezone) {
        try {
            if (url.startsWith("jdbc:postgresql:")) {
                return new JdbcConnector(url, timezone);
            } else if (url.startsWith("jdbc:sqlserver:")) {
                return new JdbcMsConnector(url);
            }
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException(ex.getLocalizedMessage(), ex);
        }
        throw new IllegalArgumentException(
                "Unknown url schema, supported schemas are 'postgresql' and 'sqlserver'");
    }

    private static String urlDecode(String encoded) {
        try {
            return URLDecoder.decode(encoded, Consts.UTF_8);
        } catch (UnsupportedEncodingException ex) {
            LOG.error(ex.getLocalizedMessage(), ex);
            return encoded;
        }
    }

    public JdbcConnector(String host, int port, String user, String pass, String dbName, String timezone) {
        this(host, port, user, pass, dbName, null, false, timezone);
    }

    public JdbcConnector(String host, int port, String user, String pass, String dbName,
            Map<String, String> properties, boolean readOnly, String timezone) {
        this.host = host;
        this.port = port < 1 ? DEFAULT_PORT : port;
        this.dbName = dbName;
        this.user = user.isEmpty() ? System.getProperty("user.name") : user;
        this.pass = pass == null || pass.isEmpty() ? getPgPassPassword() : pass;
        this.url = generateBasicConnectionString();

        this.timezone = timezone;
        this.properties = properties;
        this.readOnly = readOnly;
    }

    protected JdbcConnector() {
        // no impl, unintialized instance
    }

    private JdbcConnector(String url, String timezone) throws URISyntaxException {
        this.url = url;
        this.timezone = timezone;

        String host = null;
        String user = null;
        String pass = null;
        String dbName = null;
        int port = -1;
        // strip jdbc:, URI doesn't understand schemas with colons
        URI uri = new URI(url.substring(5));

        if (uri.isOpaque()) {
            // special case for jdbc:postgres:database_name
            dbName = uri.getSchemeSpecificPart();
        } else {
            host = uri.getHost();
            port = uri.getPort();
            dbName = uri.getPath();
            if (dbName != null && !dbName.isEmpty()) {
                // strip leading /
                dbName = dbName.substring(1);
            }

            String query = uri.getRawQuery();
            if (query != null) {
                for (String param : query.split("&")) {
                    int eq = param.indexOf('=');
                    if (eq == -1) {
                        continue;
                    }

                    String key = urlDecode(param.substring(0, eq));
                    String val = urlDecode(param.substring(eq + 1));
                    switch (key) {
                    case "user":
                        user = val;
                        break;
                    case "password":
                        pass = val;
                        break;
                    default:
                        break;
                    }
                }
            }
        }
        this.host = host == null ? "" : host;
        this.port = port < 1 ? DEFAULT_PORT : port;
        this.dbName = dbName == null ? "" : dbName;
        this.user = user == null || user.isEmpty() ? System.getProperty("user.name") : user;
        this.pass = pass == null || pass.isEmpty() ? getPgPassPassword() : pass;
    }

    /**
     * @return connection string derived from {@link #host}, {@link #port}
     *          and {@link #dbName}
     */
    protected String generateBasicConnectionString() {
        String db;
        try {
            db = URLEncoder.encode(dbName, Consts.UTF_8);
        } catch (UnsupportedEncodingException ex) {
            LOG.error(ex.getLocalizedMessage(), ex);
            db = dbName;
        }
        return "jdbc:postgresql://" + host + ':' + port + '/' + db;
    }

    /**
     * Creates new connection instance with params specified in constructor.<br>
     * It is the caller responsibility to close connection.
     *
     * @return new connection
     * @throws IOException  If driver not found or a database access error occurs
     */
    public Connection getConnection() throws IOException {
        try{
            Connection connection = establishConnection();
            connection.setReadOnly(readOnly);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    protected Connection establishConnection() throws SQLException, IOException, ClassNotFoundException {
        LOG.info("Establishing JDBC connection with host:port {}:{}, db name {}, username {}", //$NON-NLS-1$
                host, port, dbName, user);
        // driver is not visible due to the way it is loaded from the target platform
        Class.forName(getDriverName());
        return DriverManager.getConnection(url, makeProperties());
    }

    protected String getDriverName() {
        return DRIVER_NAME;
    }

    protected Properties makeProperties() {
        Properties props = new Properties();

        if (properties != null) {
            properties.entrySet().forEach(entry -> props.setProperty(entry.getKey(), entry.getValue()));
        }

        props.setProperty("user", user);
        props.setProperty("password", pass);

        String coreVer = "unknown";
        BundleContext bctx = Activator.getContext();
        if (bctx != null) {
            coreVer = bctx.getBundle().getVersion().toString();
        }
        props.setProperty("ApplicationName", "pgCodeKeeper core module, Bundle-Version: " + coreVer);

        return props;
    }

    String getTimezone(){
        return timezone;
    }

    protected String getPgPassPassword() {
        LOG.info("User provided an empty password. Reading password from pgpass file."); //$NON-NLS-1$

        try {
            String password = PgPass.get(host, String.valueOf(port), dbName, user);
            if (password != null) {
                return password;
            }
        } catch (PgPassException ex) {
            LOG.error(ex.getLocalizedMessage(), ex);
        }

        LOG.info("Using empty password, because no password has been found in pgpass file for {}:{}:{}:{}", //$NON-NLS-1$
                host, port, dbName, user);
        return "";
    }
}
