package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
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
    public static String QUERY_CHECK_LAST_SYS_OID;
    public static String QUERY_CHECK_TIMESTAMPS;

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
    public static Map <SupportedVersion, String> QUERY_FTS_PARSERS_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_FTS_TEMPLATES_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_FTS_DICTIONARIES_PER_SCHEMA;
    public static Map <SupportedVersion, String> QUERY_FTS_CONFIGURATIONS_PER_SCHEMA;

    public static String QUERY_SCHEMAS_ACCESS;
    public static String QUERY_SEQUENCES_ACCESS;
    public static String QUERY_SEQUENCES_DATA;

    public static String QUERY_SYSTEM_FUNCTIONS;
    public static String QUERY_SYSTEM_RELATIONS;
    public static String QUERY_SYSTEM_OPERATORS;
    public static String QUERY_SYSTEM_CASTS;

    public static Map <SupportedVersion, String> QUERY_MS_SCHEMAS;

    public static Map <SupportedVersion, String> QUERY_MS_TABLES;
    public static Map <SupportedVersion, String> QUERY_MS_FUNCTIONS_PROCEDURES_VIEWS_TRIGGERS;
    public static Map <SupportedVersion, String> QUERY_MS_EXTENDED_FUNCTIONS_AND_PROCEDURES;
    public static Map <SupportedVersion, String> QUERY_MS_SEQUENCES;
    public static Map <SupportedVersion, String> QUERY_MS_INDICES_AND_PK;
    public static Map <SupportedVersion, String> QUERY_MS_FK;
    public static Map <SupportedVersion, String> QUERY_MS_CHECK_CONSTRAINTS;

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
                } else if (f.getName().startsWith("QUERY_SYSTEM")) {
                    f.set(null, readResource("system/" + f.getName()));
                } else if (String.class.isAssignableFrom(f.getType())) {
                    f.set(null, readResource(f.getName()));
                }
            } catch (Exception ex) {
                Log.log(Log.LOG_ERROR,
                        "Error while loading JDBC SQL Queries resource: " + f.getName(), ex);
            }
        }
    }

    private static void fillMaps (Field f) throws Exception {
        Map <SupportedVersion, String> map  = new HashMap<>();
        f.set(null, map);

        if (f.getName().startsWith("QUERY_MS")) {
            map.put(null, readResource("ms/" + f.getName()));
            return;
        }

        map.put(null, readResource(f.getName()));

        for (SupportedVersion version : SupportedVersion.values()) {
            URL url = JdbcQueries.class.getResource(f.getName() + '_' + version + ".sql");
            if (url != null) {
                map.put(version, readResource(url));
            }
        }
    }

    private static String readResource(String name) throws IOException, URISyntaxException {
        return readResource(JdbcQueries.class.getResource(name + ".sql"));
    }

    private static String readResource(URL url) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(url).toPath()),
                StandardCharsets.UTF_8);
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