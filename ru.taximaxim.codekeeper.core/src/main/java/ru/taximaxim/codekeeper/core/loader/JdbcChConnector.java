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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import ru.taximaxim.codekeeper.core.DatabaseType;

public final class JdbcChConnector extends JdbcConnector {
    
    private static final String DRIVER_NAME = "com.clickhouse.jdbc.ClickHouseDriver";
    private static final int DEFAULT_PORT = 8123;

    public JdbcChConnector(String host, int port, String user, String pass, String dbName,
            Map<String, String> properties, boolean readOnly) {
        this.host = host;
        this.port = port < 1 ? DEFAULT_PORT : port;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;
        this.url = generateBasicConnectionString();

        this.properties = properties;
        this.readOnly = readOnly;
    }

    public JdbcChConnector(String url) throws URISyntaxException {
        this.url = url;

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
        this.user = user == null ? "" : user;
        this.pass = pass == null ? "" : pass;
    }

    @Override
    protected String generateBasicConnectionString() {
        return "jdbc:ch://" + host + ':' + port + (dbName != null ? '/' + dbName : "");
    }

    @Override
    protected DatabaseType getType() {
        return DatabaseType.CH;
    }

    @Override
    protected String getDriverName() {
        return DRIVER_NAME;
    }
}