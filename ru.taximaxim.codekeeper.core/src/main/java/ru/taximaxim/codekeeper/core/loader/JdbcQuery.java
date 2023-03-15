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

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class JdbcQuery {

    private static final String EXTENSION_QUERY = "SELECT time.objid AS oid, time.ses_user\n"
            + "FROM {0}.dbots_event_data time WHERE time.classid = {1}::pg_catalog.regclass";

    private String query;
    private final Map<SupportedVersion, String> sinceQueries = new EnumMap<>(SupportedVersion.class);
    private final Map<Pair<SupportedVersion, SupportedVersion>, String> intervalQueries = new HashMap<>();

    public String getQuery() {
        return query;
    }

    void setQuery(String query) {
        this.query = query;
    }

    void addSinceQuery(SupportedVersion since, String query) {
        sinceQueries.put(since, query);
    }

    void addIntervalQuery(SupportedVersion since, SupportedVersion until, String query) {
        intervalQueries.put(new Pair<>(since, until), query);
    }

    public String makeQuery(JdbcLoaderBase loader, String classId) {
        return makeQuery(loader, false, classId);
    }

    /**
     * @param classId postgres only: name of the object class id,
     *          i.e. the pg_catalog table which stores oid's for the object type
     * @return query or null, if filterSchemas is true and no schemas are requested
     *          (fast path for an obviously empty query result)
     */
    public String makeQuery(JdbcLoaderBase loader, boolean filterSchemas, String classId) {
        if (filterSchemas && loader.getSchemas().isEmpty()) {
            return null;
        }

        int version = loader.getVersion();
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(query);
        sb.append(") t1 \n");

        sinceQueries.entrySet().stream()
        .filter(e -> e.getKey().isLE(version))
        .forEach(e -> appendQuery(sb, e.getValue(), Integer.toString(e.getKey().getVersion())));

        intervalQueries.entrySet().stream()
        .filter(e -> e.getKey().getFirst().isLE(version) && !e.getKey().getSecond().isLE(version))
        .forEach(e -> appendQuery(sb, e.getValue(),
                e.getKey().getFirst().getVersion() + "_" + e.getKey().getSecond().getVersion()));

        String extensionSchema = loader.getExtensionSchema();
        if (extensionSchema != null) {
            // join extension data with a left join
            sb.append("LEFT ");
            appendQuery(sb, MessageFormat.format(
                    EXTENSION_QUERY, PgDiffUtils.getQuotedName(extensionSchema),
                    PgDiffUtils.quoteString("pg_catalog." + classId)), "_dbots");
        }

        if (filterSchemas) {
            sb.append("WHERE schema_oid IN (");
            for (Long id : loader.getSchemas().keySet()) {
                sb.append(id).append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(')');
        }
        return sb.toString();
    }

    private StringBuilder appendQuery(StringBuilder sb, String query, String versionName) {
        return sb.append("JOIN (")
                .append(query)
                .append(") t")
                .append(versionName)
                .append(" USING (oid) \n");
    }
}
