package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.loader.jdbc.ConstraintsReader.ConstraintsReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsConfigurationsReader.FtsConfigurationsReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsDictionariesReader.FtsDictionariesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsParsersReader.FtsParsersReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsTemplatesReader.FtsTemplatesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.FunctionsReader.FunctionsReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.IndicesReader.IndicesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.RulesReader.RulesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader.SequencesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.TablesReader.TablesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.TriggersReader.TriggersReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.TypesReader.TypesReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.ViewsReader.ViewsReaderFactory;

public abstract class JdbcReaderFactory {

    /**
     * Bit mask that if set signifies that {@link #helperFunction} is available in the database.
     */
    protected final long hasHelperMask;
    protected final String helperFunction;
    protected final Map<SupportedVersion, String> queries;

    public String getHelperFunction() {
        return helperFunction;
    }

    public JdbcReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
        this.hasHelperMask = hasHelperMask;
        this.helperFunction = helperFunction;
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

    public static final List<? extends JdbcReaderFactory> FACTORIES;
    static {
        // SONAR-OFF
        // NOTE: order of readers has been changed to move the heaviest ANTLR tasks to the beginning
        // to give them a chance to finish while JDBC processes other non-ANTLR stuff
        int i = 0;
        FACTORIES = Collections.unmodifiableList(Arrays.asList(
                new ViewsReaderFactory(            1 << i++, "get_all_views",              JdbcQueries.QUERY_VIEWS_PER_SCHEMA),
                new TablesReaderFactory(           1 << i++, "get_all_tables",             JdbcQueries.QUERY_TABLES_PER_SCHEMA),
                new RulesReaderFactory(            1 << i++, "get_all_rules",              JdbcQueries.QUERY_RULES_PER_SCHEMA),
                new TriggersReaderFactory(         1 << i++, "get_all_triggers",           JdbcQueries.QUERY_TRIGGERS_PER_SCHEMA),
                new IndicesReaderFactory(          1 << i++, "get_all_indices",            JdbcQueries.QUERY_INDICES_PER_SCHEMA),
                new FunctionsReaderFactory(        1 << i++, "get_all_functions",          JdbcQueries.QUERY_FUNCTIONS_PER_SCHEMA),
                // non-ANTLR tasks
                new ConstraintsReaderFactory(      1 << i++, "get_all_constraints",        JdbcQueries.QUERY_CONSTRAINTS_PER_SCHEMA),
                new TypesReaderFactory(            1 << i++, "get_all_types",              JdbcQueries.QUERY_TYPES_PER_SCHEMA),
                new SequencesReaderFactory(        1 << i++, "get_all_sequences",          JdbcQueries.QUERY_SEQUENCES_PER_SCHEMA),

                new FtsParsersReaderFactory(       1 << i++, "get_all_fts_parsers",        JdbcQueries.QUERY_FTS_PARSERS_PER_SCHEMA),
                new FtsTemplatesReaderFactory(     1 << i++, "get_all_fts_templates",      JdbcQueries.QUERY_FTS_TEMPLATES_PER_SCHEMA),
                new FtsDictionariesReaderFactory(  1 << i++, "get_all_fts_dictionaries",   JdbcQueries.QUERY_FTS_DICTIONARIES_PER_SCHEMA),
                new FtsConfigurationsReaderFactory(1 << i++, "get_all_fts_configurations", JdbcQueries.QUERY_FTS_CONFIGURATIONS_PER_SCHEMA)
                // SONAR-ON
                ));
    }

    /**
     * Exclude oids from query
     *
     * @param base - base query
     * @param oids - oids separated by commas
     * @return new query
     */
    public static String excludeObjects(String base, String oids) {
        StringBuilder sb = new StringBuilder("SELECT * FROM (");
        sb.append(base);
        sb.append(") q WHERE NOT (q.oid = ANY (ARRAY [");
        sb.append(oids);
        sb.append("]));");
        return sb.toString();
    }

    public static long getAllHelperBits() {
        long bits = 0;
        for (JdbcReaderFactory f : FACTORIES) {
            bits |= f.hasHelperMask;
        }
        return bits;
    }
}
