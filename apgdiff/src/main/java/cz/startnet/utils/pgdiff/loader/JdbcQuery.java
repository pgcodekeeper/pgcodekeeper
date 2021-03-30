package cz.startnet.utils.pgdiff.loader;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class JdbcQuery {

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

    public String makeQuery(int version, Set<Long> schemaIds) {
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(query);
        sb.append(") t1 ");

        sinceQueries.entrySet().stream()
        .filter(e -> e.getKey().isLE(version))
        .forEach(e -> appendQuery(sb, e.getValue(), Integer.toString(e.getKey().getVersion())));

        intervalQueries.entrySet().stream()
        .filter(e -> e.getKey().getFirst().isLE(version) && !e.getKey().getSecond().isLE(version))
        .forEach(e -> appendQuery(sb, e.getValue(),
                e.getKey().getFirst().getVersion() + "_" + e.getKey().getSecond().getVersion()));
        if (!schemaIds.isEmpty()) {
            sb.append("WHERE schema_oid IN (");
            for (Long id : schemaIds) {
                sb.append(id).append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(')');
        }
        return sb.toString();
    }

    private StringBuilder appendQuery(StringBuilder sb, String query, String versionName) {
        return sb.append("LEFT JOIN (")
                .append(query)
                .append(") t")
                .append(versionName)
                .append(" USING (oid) ");
    }
}
