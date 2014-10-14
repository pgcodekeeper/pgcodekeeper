package ru.taximaxim.codekeeper.apgdiff;

/**
 * Stores string constants
 * 
 * @author Anton Ryabinin
 */
public interface ApgdiffConsts {
    
    String APGDIFF_PLUGIN_ID = "apgdiff";
    
    String FILENAME_WORKING_DIR_MARKER = ".pgcodekeeper";
    String VERSION_PROP_NAME = "version"; //$NON-NLS-1$
    String EXPORT_CURRENT_VERSION = "0.2.14"; //$NON-NLS-1$
    String EXPORT_MIN_VERSION = "0.2.9"; //$NON-NLS-1$
    
    enum WORK_DIR_NAMES {
        EXTENSION,
        SCHEMA
    }
    
    interface JDBC_CONSTS{
        String JDBC_DRIVER = "org.postgresql.Driver";
        int JDBC_DEFAULT_PORT = 5432;
    }
}
