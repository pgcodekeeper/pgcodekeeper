package cz.startnet.utils.pgdiff.loader;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;

/**
 * For every field in this class that starts with 'QUERY_'
 * the static initializer tries to find a file named
 * %FIELD_NAME%.sql in this package and assign its contents to the field.<br>
 * Similar to {@link org.eclipse.osgi.util.NLS}, OSGi localization classes.
 * 
 * @author levsha_aa
 */
public final class JdbcQueries {
    
// SONAR-OFF
    public static String QUERY_TABLES_PER_SCHEMA;
    public static String QUERY_FUNCTIONS_PER_SCHEMA;
    public static String QUERY_SEQUENCES_PER_SCHEMA;
    public static String QUERY_INDICES_PER_SCHEMA;
    public static String QUERY_CONSTRAINTS_PER_SCHEMA;
    public static String QUERY_COLUMNS_PER_SCHEMA;
    public static String QUERY_EXTENSIONS;
    public static String QUERY_SCHEMAS;
    public static String QUERY_TRIGGERS_PER_SCHEMA;
    public static String QUERY_VIEWS_PER_SCHEMA;
    public static String QUERY_TOTAL_OBJECTS_COUNT;
    public static String QUERY_TYPES_FOR_CACHE_ALL;
    public static String QUERY_TYPES_PER_SCHEMA;
// SONAR-ON
    
    static {
        for (Field f : JdbcQueries.class.getFields()) {
            if (!f.getName().startsWith("QUERY_")) {
                continue;
            }
            
            try {
                String query = new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                                JdbcQueries.class.getResource(f.getName() + ".sql")).toPath()),
                        Charset.forName(ApgdiffConsts.UTF_8));
                f.set(null, query);
            } catch (Exception ex) {
                Log.log(Log.LOG_ERROR,
                        "Error while loading JDBC SQL Queries resource: " + f.getName(), ex);
            }
        }
    }
    
    private JdbcQueries() {
    }
}
