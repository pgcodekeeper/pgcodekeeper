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
        SCHEMA,
        EXTENSION
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
    
    String[] SYS_TYPES = {
            "abstime", //$NON-NLS-1$
            "aclitem", //$NON-NLS-1$
            "any", //$NON-NLS-1$
            "anyarray", //$NON-NLS-1$
            "anyelement", //$NON-NLS-1$
            "anyenum", //$NON-NLS-1$
            "anynonarray", //$NON-NLS-1$
            "anyrange", //$NON-NLS-1$
            "bigint", //$NON-NLS-1$
            "bit", //$NON-NLS-1$
            "bit varying", //$NON-NLS-1$
            "boolean", //$NON-NLS-1$
            "box", //$NON-NLS-1$
            "bytea", //$NON-NLS-1$
            "char", //$NON-NLS-1$
            "character", //$NON-NLS-1$
            "character varying", //$NON-NLS-1$
            "cid", //$NON-NLS-1$
            "cidr", //$NON-NLS-1$
            "circle", //$NON-NLS-1$
            "cstring", //$NON-NLS-1$
            "date", //$NON-NLS-1$
            "daterange", //$NON-NLS-1$
            "double precision", //$NON-NLS-1$
            "event_trigger", //$NON-NLS-1$
            "fdw_handler", //$NON-NLS-1$
            "gtsvector", //$NON-NLS-1$
            "inet", //$NON-NLS-1$
            "int2vector", //$NON-NLS-1$
            "int4range", //$NON-NLS-1$
            "int8range", //$NON-NLS-1$
            "integer", //$NON-NLS-1$
            "internal", //$NON-NLS-1$
            "interval", //$NON-NLS-1$
            "json", //$NON-NLS-1$
            "language_handler", //$NON-NLS-1$
            "line", //$NON-NLS-1$
            "lseg", //$NON-NLS-1$
            "macaddr", //$NON-NLS-1$
            "money", //$NON-NLS-1$
            "name", //$NON-NLS-1$
            "numeric", //$NON-NLS-1$
            "numrange", //$NON-NLS-1$
            "oid", //$NON-NLS-1$
            "oidvector", //$NON-NLS-1$
            "opaque", //$NON-NLS-1$
            "path", //$NON-NLS-1$
            "pg_node_tree", //$NON-NLS-1$
            "point", //$NON-NLS-1$
            "polygon", //$NON-NLS-1$
            "real", //$NON-NLS-1$
            "record", //$NON-NLS-1$
            "refcursor", //$NON-NLS-1$
            "regclass", //$NON-NLS-1$
            "regconfig", //$NON-NLS-1$
            "regdictionary", //$NON-NLS-1$
            "regoper", //$NON-NLS-1$
            "regoperator", //$NON-NLS-1$
            "regproc", //$NON-NLS-1$
            "regprocedure", //$NON-NLS-1$
            "regtype", //$NON-NLS-1$
            "reltime", //$NON-NLS-1$
            "smallint", //$NON-NLS-1$
            "smgr", //$NON-NLS-1$
            "text", //$NON-NLS-1$
            "tid", //$NON-NLS-1$
            "timestamp without time zone", //$NON-NLS-1$
            "timestamp with time zone", //$NON-NLS-1$
            "time without time zone", //$NON-NLS-1$
            "time with time zone", //$NON-NLS-1$
            "tinterval", //$NON-NLS-1$
            "trigger", //$NON-NLS-1$
            "tsquery", //$NON-NLS-1$
            "tsrange", //$NON-NLS-1$
            "tstzrange", //$NON-NLS-1$
            "tsvector", //$NON-NLS-1$
            "txid_snapshot", //$NON-NLS-1$
            "unknown", //$NON-NLS-1$
            "uuid", //$NON-NLS-1$
            "void", //$NON-NLS-1$
            "xid", //$NON-NLS-1$
            "xml" //$NON-NLS-1$
    };
}
