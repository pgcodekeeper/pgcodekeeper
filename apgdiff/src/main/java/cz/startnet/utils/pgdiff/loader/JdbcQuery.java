package cz.startnet.utils.pgdiff.loader;

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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
        return makeQuery(loader, null, classId);
    }

    /**
     * @param classId postgres only: name of the object class id,
     *          i.e. the pg_catalog table which stores oid's for the object type
     */
    public String makeQuery(JdbcLoaderBase loader, Set<Long> schemaIds, String classId) {
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
            appendQuery(sb, MessageFormat.format(
                    EXTENSION_QUERY, PgDiffUtils.getQuotedName(extensionSchema),
                    PgDiffUtils.quoteString("pg_catalog." + classId)), "_dbots");
        }

        if (schemaIds != null) {
            sb.append("WHERE schema_oid = ANY (ARRAY[");
            if (!schemaIds.isEmpty()) {
                for (Long id : schemaIds) {
                    sb.append(id).append(',');
                }
                sb.setLength(sb.length() - 1);
            }
            sb.append("]::oid[])");
        }
        return sb.toString();
    }

    private StringBuilder appendQuery(StringBuilder sb, String query, String versionName) {
        return sb.append("LEFT JOIN (")
                .append(query)
                .append(") t")
                .append(versionName)
                .append(" USING (oid) \n");
    }
}
