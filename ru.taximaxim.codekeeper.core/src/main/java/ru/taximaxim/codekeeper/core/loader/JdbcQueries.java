/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader;

public class JdbcQueries {

    private static final String NSPNAME = "n.nspname";
    private static final String SYSTEM_SCHEMAS = "(n.nspname LIKE 'pg\\_%' OR n.nspname = 'information_schema')";

    public static final String QUERY_TOTAL_OBJECTS_COUNT = getObjectsCountQuery();
    public static final String QUERY_TYPES_FOR_CACHE_ALL = getTypesForCacheQuery();
    public static final String QUERY_CHECK_TIMESTAMPS = getCheckTimestampsQuery();
    public static final String QUERY_CHECK_LAST_SYS_OID = getCheckLastSysOidQuery();
    public static final String QUERY_CHECK_USER_PRIVILEGES = getCheckUserPrivilegesQuery();
    public static final String QUERY_CHECK_PG_VERSION = getCheckPgVersionQuery();
    public static final String QUERY_CHECK_GREENPLUM = getCheckGreenplumQuery();
    public static final String QUERY_CHECK_MS_VERSION = getCheckMsVersionQuery();
    public static final String QUERY_SCHEMAS_ACCESS = getSchemasAccessQuery();
    public static final String QUERY_SEQUENCES_ACCESS = getSequencesAccessQuery();
    public static final String QUERY_SEQUENCES_DATA =   getSequencesDataQuery();
    public static final String QUERY_SYSTEM_FUNCTIONS = getSystemFunctionsQuery();
    public static final String QUERY_SYSTEM_RELATIONS = getSystemRelationsQuery();
    public static final String QUERY_SYSTEM_OPERATORS = getSystemOperatorsQuery();
    public static final String QUERY_SYSTEM_CASTS = getSystemCastsQuery();

    private static String getObjectsCountQuery() {
        return new QueryBuilder()
                .column("pg_catalog.count(c.oid)::integer")
                .from("pg_catalog.pg_class c")
                .where("c.relnamespace IN (SELECT nsp.oid FROM pg_catalog.pg_namespace nsp WHERE nsp.nspname NOT LIKE ('pg_%') AND nsp.nspname != 'information_schema')")
                .where("c.relkind != 't'")
                .build();
    }

    private static String getTypesForCacheQuery() {
        return new QueryBuilder()
                .column("t.oid")
                .column("t.typname")
                .column("t.typelem")
                .column("t.typarray")
                .column("te.typname AS elemname")
                .column(NSPNAME)
                .from("pg_catalog.pg_type t")
                .join("LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid")
                .join("LEFT JOIN pg_catalog.pg_type te ON te.oid = t.typelem")
                .build();
    }

    private static String getCheckTimestampsQuery() {
        return new QueryBuilder()
                .column(NSPNAME)
                .column("e.extversion")
                .column("EXISTS (SELECT 1 FROM pg_catalog.pg_event_trigger WHERE evtenabled != 'O' "
                        + "AND (evtname = 'dbots_tg_on_ddl_event' OR evtname = 'dbots_tg_on_drop_event')) AS disabled")
                .from("pg_catalog.pg_namespace n")
                .join("LEFT JOIN pg_catalog.pg_extension e on e.extnamespace = n.oid")
                .where("e.extname = 'pg_dbo_timestamp'")
                .build();
    }

    private static String getCheckLastSysOidQuery() {
        return new QueryBuilder()
                .column("datlastsysoid::bigint")
                .from("pg_catalog.pg_database")
                .where("datname = pg_catalog.current_database()")
                .build();
    }

    private static String getCheckUserPrivilegesQuery() {
        return new QueryBuilder()
                .column("pg_catalog.has_table_privilege('pg_catalog.pg_user_mapping', 'SELECT') AS result")
                .build();
    }

    private static String getCheckPgVersionQuery() {
        return new QueryBuilder()
                .column("CAST (pg_catalog.current_setting('server_version_num') AS INT)")
                .build();
    }

    private static String getCheckGreenplumQuery() {
        return new QueryBuilder()
                .column("version()")
                .build();
    }

    private static String getCheckMsVersionQuery() {
        return new QueryBuilder()
                .column("CAST(LEFT(CAST(SERVERPROPERTY('productversion') AS varchar), 2) AS INT)")
                .build();
    }

    private static String getSchemasAccessQuery() {
        return new QueryBuilder()
                .column(NSPNAME)
                .column("pg_catalog.has_schema_privilege(n.nspname, 'USAGE') AS has_priv")
                .from("(SELECT pg_catalog.unnest(?)) n(nspname)")
                .build();
    }

    private static String getSystemFunctionsQuery() {
        return new QueryBuilder()
                .column("p.proname AS name")
                .column(NSPNAME)
                .column("p.proargmodes")
                .column("p.proretset")
                .column("p.proargnames")
                .column("pg_catalog.format_type(p.prorettype, null) AS prorettype")
                .column("p.proallargtypes::bigint[]")
                .column("pg_catalog.pg_get_function_arguments(p.oid) AS proarguments")
                .from("pg_catalog.pg_proc p")
                .join("LEFT JOIN pg_catalog.pg_namespace n ON p.pronamespace = n.oid")
                .where("NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp"
                        + " WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass"
                        + " AND dp.objid = p.oid AND dp.deptype = 'i')")
                .where(SYSTEM_SCHEMAS)
                .build();
    }

    private static String getSystemRelationsQuery() {
        return new QueryBuilder()
                .column("c.relname AS name")
                .column("c.relkind")
                .column(NSPNAME)
                .column("columns.col_names")
                .column("columns.col_types")
                .from("pg_catalog.pg_class c")
                .join("LEFT JOIN (SELECT"
                        + "   a.attrelid,"
                        + "   pg_catalog.array_agg(a.attname ORDER BY a.attnum) AS col_names,"
                        + "   pg_catalog.array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS col_types"
                        + " FROM pg_catalog.pg_attribute a"
                        + " WHERE a.attisdropped IS FALSE AND a.attnum > 0"
                        + " GROUP BY attrelid) columns ON columns.attrelid = c.oid")
                .join("LEFT JOIN pg_catalog.pg_namespace n ON c.relnamespace = n.oid")
                .where("c.relkind IN ('f','r','p', 'v', 'm', 'S')")
                .where(SYSTEM_SCHEMAS)
                .build();
    }

    private static String getSystemOperatorsQuery() {
        return new QueryBuilder()
                .column("o.oprname as name")
                .column(NSPNAME)
                .column("o.oprleft::bigint AS left")
                .column("o.oprright::bigint AS right")
                .column("o.oprresult::bigint AS result")
                .from("pg_catalog.pg_operator o")
                .join("LEFT JOIN pg_catalog.pg_namespace n ON o.oprnamespace = n.oid")
                .where(SYSTEM_SCHEMAS)
                .build();
    }

    private static String getSystemCastsQuery() {
        return new QueryBuilder()
                .column("pg_catalog.format_type(c.castsource, null) AS source")
                .column("pg_catalog.format_type(c.casttarget, null) AS target")
                .column("c.castcontext")
                .from("pg_catalog.pg_cast c")
                .where("c.oid <= ?")
                .build();
    }

    private static String getSequencesAccessQuery() {
        return new QueryBuilder()
                .column("s.qname")
                .column("pg_catalog.has_sequence_privilege(s.qname, 'SELECT') AS has_priv")
                .from("(SELECT pg_catalog.unnest(?)) s(qname)")
                .build();
    }

    private static String getSequencesDataQuery() {
        return new QueryBuilder()
                .column("start_value")
                .column("increment_by")
                .column("max_value")
                .column("min_value")
                .column("cache_value")
                .column("is_cycled")
                .build();
    }

    private JdbcQueries() {}
}
