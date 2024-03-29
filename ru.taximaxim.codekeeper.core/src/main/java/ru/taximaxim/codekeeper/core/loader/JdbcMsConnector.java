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
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;

public class JdbcMsConnector extends JdbcConnector {

    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final int DEFAULT_PORT = 1433;
    private static final Pattern PATTERN_PROPERTIES =
            Pattern.compile(";(?:(\\w+)=(\\w+|\\{[^}]*\\})?)?");

    private final boolean winAuth;
    private String domain;

    private static String unescapeValue(String val) {
        if (val != null && val.length() > 1 && val.charAt(0) == '{') {
            // strip escape braces
            return val.substring(1, val.length() - 1);
        }
        return val;
    }

    public JdbcMsConnector(String host, int port, String user, String pass, String dbName,
            Map<String, String> properties, boolean readOnly, boolean winAuth, String domain) {
        this.host = host;
        this.port = port < 1 ? DEFAULT_PORT : port;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass == null || pass.isEmpty() ? getPgPassPassword() : pass;
        this.url = generateBasicConnectionString();

        this.properties = properties;
        this.readOnly = readOnly;
        this.winAuth = winAuth;

        this.domain = domain;
    }

    protected JdbcMsConnector(String url) throws URISyntaxException {
        this.url = url;

        // strip jdbc:, URI doesn't understand schemas with colons
        String uriPart = url.substring(5);
        int semic = uriPart.indexOf(';');
        if (semic > -1) {
            Matcher m = PATTERN_PROPERTIES.matcher(uriPart.substring(semic));

            // strip properties string from URI text
            uriPart = uriPart.substring(0, semic);

            while (m.find()) {
                if (m.groupCount() < 2) {
                    // 0 = no groups, only lone semicolon matched
                    // 1 = no value, not interested
                    continue;
                }
                String s = m.group(1).toLowerCase(Locale.ROOT);
                String value = unescapeValue(m.group(2));
                switch (s) {
                case "user":
                case "username":
                    this.user = value;
                    break;
                case "password":
                    this.pass = value;
                    break;
                case "database":
                case "databasename":
                    this.dbName = value;
                    break;
                case "domain":
                    this.domain = value;
                    break;
                case "trustservercertificate":
                    // override our legacy-default with user-supplied value
                    properties = new HashMap<>();
                    properties.put(Consts.TRUST_CERT, value);
                    break;
                default:
                    break;
                }
            }
        }
        URI uri = new URI(uriPart);
        int port = uri.getPort();

        this.host = uri.getHost();
        this.port = port < 1 ? DEFAULT_PORT : port;

        if (dbName == null) {
            dbName = "";
        }
        if (user == null) {
            user = "";
        }
        if (pass == null) {
            pass = "";
        }
        // should be provided in the connection string
        this.winAuth = false;
    }

    @Override
    protected String generateBasicConnectionString() {
        return "jdbc:sqlserver://" + host + ':' + port
                + (isDbNameEscapable() ? ";databaseName={" + dbName + '}' : "");
    }

    @Override
    protected Properties makeProperties() {
        Properties props = super.makeProperties();
        if (!isDbNameEscapable()) {
            props.setProperty("databaseName", dbName);
        }
        if (winAuth) {
            props.setProperty("integratedSecurity", "true");
        } else if (domain != null && !"".equals(domain)) {
            props.setProperty("authenticationScheme", "NTLM");
            props.setProperty("integratedSecurity", "true");
            props.setProperty("domain", domain);
        }
        if (props.getProperty(Consts.TRUST_CERT) == null) {
            // revert to pre-10.x jdbc driver behavior unless told otherwise
            props.setProperty(Consts.TRUST_CERT, "true");
        }
        return props;
    }

    private boolean isDbNameEscapable() {
        return dbName.indexOf('}') < 0;
    }

    @Override
    protected String getDriverName() {
        return DRIVER_NAME;
    }

    @Override
    protected DatabaseType getType() {
        return DatabaseType.MS;
    }

    @Override
    protected Connection establishConnection() throws SQLException, IOException, ClassNotFoundException {
        try {
            return super.establishConnection();
        } catch (SQLException ex) {
            Throwable t = ex.getCause();
            if (t instanceof UnsatisfiedLinkError) {
                // give more detailed errors for win auth/other lib failures
                throw new IOException(
                        ex.getLocalizedMessage()
                        + "\n\n" +
                        t.getLocalizedMessage(),
                        ex);
            } else {
                throw ex;
            }
        }
    }
}
