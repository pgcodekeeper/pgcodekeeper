WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'    
), extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_catalog.pg_extension'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT c.oid::bigint,
       c.cfgname,
       c.cfgowner::bigint,
       p.prsname,
       n.nspname AS prsnspname,
       words.tokennames,
       words.dictschemas,
       words.dictnames,
       d.description AS comment,
       c.cfgnamespace AS schema_oid
FROM pg_ts_config c
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid 
LEFT JOIN pg_catalog.pg_ts_parser p ON p.oid = c.cfgparser
LEFT JOIN pg_catalog.pg_namespace n ON p.prsnamespace = n.oid
LEFT JOIN LATERAL (
    SELECT
        m.mapcfg,
        pg_catalog.array_agg(
            (SELECT alias 
            FROM pg_catalog.ts_token_type(c.cfgparser::pg_catalog.oid) AS t 
            WHERE t.tokid = m.maptokentype) 
            ORDER BY m.mapseqno) AS tokennames,
        pg_catalog.array_agg(nsp.nspname ORDER BY m.mapseqno) AS dictschemas,
        pg_catalog.array_agg(dict.dictname ORDER BY m.mapseqno) AS dictnames
    FROM pg_catalog.pg_ts_config_map m
    LEFT JOIN pg_catalog.pg_ts_dict dict ON m.mapdict = dict.oid 
    LEFT JOIN pg_catalog.pg_namespace nsp ON dict.dictnamespace = nsp.oid   
    GROUP BY m.mapcfg
) words ON words.mapcfg = c.oid
WHERE c.cfgnamespace NOT IN (SELECT oid FROM sys_schemas) 
      AND c.oid NOT IN (SELECT objid FROM extension_deps)