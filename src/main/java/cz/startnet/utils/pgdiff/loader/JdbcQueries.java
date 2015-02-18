package cz.startnet.utils.pgdiff.loader;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;

public final class JdbcQueries {
    
    private final static String RES_ENCODING = ApgdiffConsts.UTF_8;
    
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
// SONAR-ON
    
    static {
        for (Field f : JdbcQueries.class.getFields()) {
            if (!f.getName().startsWith("QUERY_")) {
                continue;
            }
            
            try {
                String query = new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                                JdbcQueries.class.getResource(f.getName() + ".sql")).toPath()),
                        Charset.forName(RES_ENCODING));
                f.set(null, query);
            } catch (Exception ex) {
                Log.log(Log.LOG_ERROR, "Error while loading JDBC SQL Queries resources!", ex);
            }
        }
    }
    
    private JdbcQueries() {
    }
}
