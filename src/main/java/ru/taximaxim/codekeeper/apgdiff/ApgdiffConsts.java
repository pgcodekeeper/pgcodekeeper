package ru.taximaxim.codekeeper.apgdiff;

/**
 * Stores string constants
 * 
 * @author Anton Ryabinin
 */
public interface ApgdiffConsts {
    String APGDIFF_PLUGIN_ID = "apgdiff";
    
    String FILENAME_WORKING_DIR_MARKER = ".pgcodekeeper";
    String VERSION_PROP_NAME = "version";
    
    enum WORK_DIR_NAMES {
        EXTENSION,
        SCHEMA
    }
}
