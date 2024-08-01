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

import java.util.Properties;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;

public final class UrlJdbcConnector extends AbstractJdbcConnector {

    private static final String MESSAGE_UNKNOWN_URL_SCHEMA = "Unknown url schema, supported schemas are 'postgresql', 'sqlserver', 'ch', 'clickhouse'";

    private final String url;

    public UrlJdbcConnector(String url) {
        super(getDatabaseTypeFromUrl(url));
        this.url = url;
    }

    @Override
    protected Properties makeProperties() {
        Properties props = super.makeProperties();
        if (url != null && !url.contains(Consts.TRUST_CERT)) {
            // revert to pre-10.x jdbc driver behavior unless told otherwise
            props.setProperty(Consts.TRUST_CERT, "true");
        }
        return props;
    }

    @Override
    protected String getUrl() {
        return url;
    }

    public static DatabaseType getDatabaseTypeFromUrl(String url) {
        if (url.startsWith(URL_START_MS)) {
            return DatabaseType.MS;
        }
        if (url.startsWith(URL_START_CH) || url.startsWith(URL_START_CH_SHORT)) {
            return DatabaseType.CH;
        }
        if (url.startsWith(URL_START_PG)) {
            return DatabaseType.PG;
        }
        throw new IllegalArgumentException(MESSAGE_UNKNOWN_URL_SCHEMA);
    }
}