package cz.startnet.utils.pgdiff.loader;

import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.jdbc.JdbcReaderFactory;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;

/**
 * For every field in this class that starts with 'QUERY_'
 * the static initializer tries to: <br>
 * - if the field is String: find a file named %FIELD_NAME%.sql in this package
 *   and assign its contents to the field.<br>
 * - if the field is Map: load %FIELD_NAME%.sql as described above and map its contents to null,
 *   try to load every %FIELD_NAME%_%VERSION%.sql and map their contents with their versions.
 *
 * Similar to {@link org.eclipse.osgi.util.NLS}, OSGi localization classes.
 *
 * @author levsha_aa, galiev_mr
 */
public final class JdbcQueries {

    // SONAR-OFF

    public static String QUERY_TOTAL_OBJECTS_COUNT;
    public static String QUERY_TYPES_FOR_CACHE_ALL;
    public static String QUERY_HELPER_FUNCTIONS;
    public static String QUERY_CHECK_VERSION;
    public static String QUERY_CHECK_TIMESTAMPS;

    public static String QUERY_OBJECTS_TIMESTAMP;
    public static String QUERY_TIMESTAMPS;

    public static String QUERY_HELPER_FUNCTION_TEMPLATE;
    public static String QUERY_HELPER_FUNCTIONS_BEGIN;

    public static Map <SupportedVersion, String> QUERY_EXTENSIONS;
    public static Map <SupportedVersion, String> QUERY_SCHEMAS;

    public static Map <SupportedVersion, String> QUERY_TABLES_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_FUNCTIONS_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_SEQUENCES_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_INDICES_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_CONSTRAINTS_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_TRIGGERS_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_VIEWS_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_TYPES_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_RULES_PER_SCHEMA;

    public static String QUERY_SCHEMAS_ACCESS;
    public static String QUERY_SEQUENCES_ACCESS;
    public static String QUERY_SEQUENCES_DATA;

    // SONAR-ON

    private static final String HELPER_NAME = "%FUNCTION_NAME%";
    private static final String HELPER_QUERY = "%FUNCTION_QUERY%";

    static {
        for (Field f : JdbcQueries.class.getFields()) {
            if (!f.getName().startsWith("QUERY")) {
                continue;
            }
            try {
                if (Map.class.isAssignableFrom(f.getType())) {
                    fillMaps(f);
                } else if (String.class.isAssignableFrom(f.getType())) {
                    String query = new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                            JdbcQueries.class.getResource(f.getName() + ".sql")).toPath()),
                            StandardCharsets.UTF_8);
                    f.set(null, query);
                }
            } catch (Exception ex) {
                Log.log(Log.LOG_ERROR,
                        "Error while loading JDBC SQL Queries resource: " + f.getName(), ex);
            }
        }
    }

    private static void fillMaps (Field f) throws Exception {
        Map <SupportedVersion, String> map  = new HashMap<>();

        String query = new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                JdbcQueries.class.getResource(f.getName() + ".sql")).toPath()),
                StandardCharsets.UTF_8);
        map.put(null, query);

        for (SupportedVersion version : SupportedVersion.values()) {
            URL url = JdbcQueries.class.getResource(f.getName() + '_' + version + ".sql");
            if (url != null) {
                query = new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                        url).toPath()), StandardCharsets.UTF_8);
                map.put(version, query);
            }
        }
        f.set(null, map);
    }

    public static String getHelperFunctions(SupportedVersion version) {
        StringBuilder sb = new StringBuilder();
        sb.append(QUERY_HELPER_FUNCTIONS_BEGIN);

        for (JdbcReaderFactory fac : JdbcReaderFactory.FACTORIES) {
            // set helper functions default PostgreSQL version 9.5

            sb.append(QUERY_HELPER_FUNCTION_TEMPLATE
                    .replace(HELPER_NAME, fac.getHelperFunction())
                    .replace(HELPER_QUERY, fac.makeFallbackQuery(version.getVersion()))
                    .replace("?", "schema_oid"));
        }
        return sb.toString();
    }

    private JdbcQueries() {
    }
}