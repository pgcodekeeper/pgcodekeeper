package ru.taximaxim.codekeeper.apgdiff;

/**
 * Stores string constants
 * 
 * @author Anton Ryabinin
 */
public interface ApgdiffConsts {
    
    String UTF_8 = "UTF-8";
    String UTC = "UTC";
    String PUBLIC = "public";
    
    String APGDIFF_PLUGIN_ID = "apgdiff";
    
    String FILENAME_WORKING_DIR_MARKER = ".pgcodekeeper";
    String VERSION_PROP_NAME = "version";
    String EXPORT_CURRENT_VERSION = "0.4.1";
    String EXPORT_MIN_VERSION = "0.2.9";
    
    enum WORK_DIR_NAMES {
        EXTENSION,
        SCHEMA
    }
    
    interface JDBC_CONSTS{
        String JDBC_DRIVER = "org.postgresql.Driver";
        int JDBC_DEFAULT_PORT = 5432;
    }
    
    interface TEST{
        String REMOTE_HOST = "10.84.0.5";
        String REMOTE_DB = "pgcodekeeper_testing";
        int REMOTE_PORT = 5432;
        String REMOTE_USERNAME = "unit_test";
        String REMOTE_PASSWORD = "***REMOVED***";
    }
}
