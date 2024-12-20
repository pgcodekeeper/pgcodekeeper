/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import java.util.Collection;
import java.util.Set;

/**
 * Stores string constants
 *
 * @author Anton Ryabinin
 */
public interface Consts {

    /**
     * Prefer using StandardCharsets instead of this String representation.
     */
    String UTF_8 = "UTF-8";
    String UTC = "UTC";
    String PUBLIC = "public";
    String DBO = "dbo";
    String CH_DEFAULT_DB = "default";
    String HEAP = "heap";

    String PG_DEFAULT = "pg_default";

    String PG_CATALOG = "pg_catalog";
    String INFORMATION_SCHEMA = "information_schema";
    String SYSTEM = "system";
    String SYS = "sys";

    String GO = "GO";

    String PLUGIN_ID = "ru.taximaxim.codekeeper.core";

    String FILENAME_WORKING_DIR_MARKER = ".pgcodekeeper";
    String VERSION_PROP_NAME = "version";
    String EXPORT_CURRENT_VERSION = "0.6.0";

    String EXTENSION_VERSION = "1.";

    String TRUST_CERT = "trustServerCertificate";

    String JDBC_SUCCESS = "success";

    String PROJECT_ONLY = "projectOnly";

    String GREENPLUM = "Greenplum";

    /**
     * Error codes for check existence objects
     */
    //If PK exists we get this error code.
    String INVALID_DEFINITION = "'42P16'";
    //If table (maybe with sequence) exists we get this error code.
    String DUPLICATE_RELATION = "'42P07'";
    //If object exists we get this error code.
    String DUPLICATE_OBJECT = "'42710'";
    
    /**
     * Log message when in the SELECT part aliases is duplicate
     */
    String DUPLICATE_ALIASES = "Duplicate aliases entry: {}";

    enum FUNC_SIGN {
        IN("(cstring)"),
        IN_ADVANCED("(cstring, oid, integer)"),
        INTERNAL("(internal)"),
        TYPMOD_IN ("(cstring[])"),
        TYPMOD_OUT ("(integer)"),
        REC_ADVANCED("(internal, oid, integer)"),
        SUBTYPE_DIFF("({0}, {0})"),
        TYPE_NAME("({0}.{1})");

        private final String name;

        FUNC_SIGN(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * @deprecated improve builtins detection using tokens and jdbc ways
     */
    @Deprecated
    Collection<String> SYS_TYPES = Set.of(
            "abstime", //$NON-NLS-1$
            "aclitem", //$NON-NLS-1$
            "any", //$NON-NLS-1$
            "anyarray", //$NON-NLS-1$
            "anyelement", //$NON-NLS-1$
            "anyenum", //$NON-NLS-1$
            "anynonarray", //$NON-NLS-1$
            "anyrange", //$NON-NLS-1$
            "bigint", //$NON-NLS-1$
            "bigserial",
            "bit", //$NON-NLS-1$
            "bit varying", //$NON-NLS-1$
            "boolean", //$NON-NLS-1$
            "box", //$NON-NLS-1$
            "bpchar",
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
            "jsonb",
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
            "serial",
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
            );
}
