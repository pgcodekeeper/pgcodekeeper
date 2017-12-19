package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.loader.jdbc.ConstraintsReader.ConstraintsReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.FunctionsReader.FunctionsReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.IndicesReader.IndicesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.RulesReader.RulesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader.SequencesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.TablesReader.TablesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.TriggersReader.TriggersReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.TypesReader.TypesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.ViewsReader.ViewsReaderFactory;
import ru.taximaxim.codekeeper.apgdiff.Log;

public abstract class JdbcReaderFactory {

    /**
     * Bit mask that if set signifies that {@link #helperFunction} is available in the database.
     */
    protected final long hasHelperMask;
    protected final String helperFunction;
    protected final String helperQuery;
    protected final Map<SupportedVersion, String> queries;

    public String getHelperFunction() {
        return helperFunction;
    }

    public JdbcReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
        this.hasHelperMask = hasHelperMask;
        this.helperFunction = helperFunction;
        this.helperQuery = "SELECT * FROM " + HELPER_SCHEMA + '.' + helperFunction + "(?,?)";
        this.queries = queries;
    }

    public abstract JdbcReader getReader(JdbcLoaderBase loader);

    public String makeFallbackQuery (int version) {
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(queries.get(null));
        sb.append(") t1 ");

        queries.entrySet().stream()
        .filter(e -> e.getKey() != null && e.getKey().checkVersion(version))
        .forEach(e -> sb.append("LEFT JOIN (").append(e.getValue())
                .append(") t").append(e.getKey().getVersion())
                .append(" USING (oid) "));

        return sb.toString();
    }

    /*
     * Static part.
     */

    private static final String HELPER_SCHEMA = "pgcodekeeperhelper";
    public static final List<? extends JdbcReaderFactory> FACTORIES = Collections.unmodifiableList(Arrays.asList(
            // SONAR-OFF
            // NOTE: order of readers has been changed to move the heaviest ANTLR tasks to the beginning
            // to give them a chance to finish while JDBC processes other non-ANTLR stuff
            new ViewsReaderFactory(      1 << 6, "get_all_views",       JdbcQueries.QUERY_VIEWS_PER_SCHEMA),
            new TablesReaderFactory(     1 << 3, "get_all_tables",      JdbcQueries.QUERY_TABLES_PER_SCHEMA),
            new RulesReaderFactory(      1 << 8, "get_all_rules",       JdbcQueries.QUERY_RULES_PER_SCHEMA),
            new TriggersReaderFactory(   1 << 7, "get_all_triggers",    JdbcQueries.QUERY_TRIGGERS_PER_SCHEMA),
            new IndicesReaderFactory(    1 << 5, "get_all_indices",     JdbcQueries.QUERY_INDICES_PER_SCHEMA),
            new FunctionsReaderFactory(  1 << 2, "get_all_functions",   JdbcQueries.QUERY_FUNCTIONS_PER_SCHEMA),
            // non-ANTLR tasks
            new ConstraintsReaderFactory(1 << 4, "get_all_constraints", JdbcQueries.QUERY_CONSTRAINTS_PER_SCHEMA),
            new TypesReaderFactory(      1 << 0, "get_all_types",       JdbcQueries.QUERY_TYPES_PER_SCHEMA),
            new SequencesReaderFactory(  1 << 1, "get_all_sequences",   JdbcQueries.QUERY_SEQUENCES_PER_SCHEMA)
            // SONAR-ON
            ));

    /**
     * @param loader loader connection must have been established
     *
     * @return helper functions that are available in the database
     *          in the form of bit field of combined {@link #hasHelperMask}s.
     */
    public static long getAvailableHelpersBits(JdbcLoaderBase loader) throws SQLException {
        loader.setCurrentOperation("available helpers query");
        return getAvailableHelperBits(loader.connection);
    }

    public static String excludeObjects(String base, List<Long> oids) {
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(base);
        sb.append(") q WHERE NOT (q.oid = ANY (ARRAY [");
        sb.append(oids.stream().map(o -> o.toString()).collect(Collectors.joining(",")));
        sb.append("]));");
        return sb.toString();
    }

    public static long getAvailableHelperBits(Connection connection) throws SQLException {
        long bits = 0;
        try (PreparedStatement st = connection.prepareStatement(JdbcQueries.QUERY_HELPER_FUNCTIONS)) {
            st.setString(1, HELPER_SCHEMA);
            try (ResultSet res = st.executeQuery()) {
                Set<String> funcs = new HashSet<>();
                while (res.next()) {
                    if (!res.getBoolean("schema_access")) {
                        Log.log(Log.LOG_WARNING, "No access to helper schema: " + HELPER_SCHEMA);
                        break;
                    }
                    String func = res.getString("proname");
                    if (res.getBoolean("function_access")) {
                        funcs.add(func);
                    } else {
                        Log.log(Log.LOG_WARNING, "No access to helper function: " + func);
                    }
                }
                for (JdbcReaderFactory factory : FACTORIES) {
                    if (funcs.contains(factory.helperFunction)) {
                        bits |= factory.hasHelperMask;
                    }
                }
            }
        }
        return bits;
    }

    public static long getAllHelperBits() {
        long bits = 0;
        for (JdbcReaderFactory f : FACTORIES) {
            bits |= f.hasHelperMask;
        }
        return bits;
    }
}
