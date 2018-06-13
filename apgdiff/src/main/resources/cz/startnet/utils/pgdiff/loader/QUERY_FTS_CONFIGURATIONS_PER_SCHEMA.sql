WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_catalog.pg_extension'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT c.oid::bigint,
       c.cfgname,
       c.cfgowner,
       p.prsname,
       n.nspname,
       words.tokennames,
       words.dictnames,
       d.description AS comment
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
            ORDER BY m.mapcfg, m.maptokentype, m.mapseqno) AS tokennames,
        pg_catalog.array_agg(m.mapdict::pg_catalog.regdictionary::text ORDER BY m.mapcfg, m.maptokentype, m.mapseqno) AS dictnames
    FROM pg_catalog.pg_ts_config_map m
    LEFT JOIN pg_catalog.pg_ts_dict dict ON m.mapdict = dict.oid 
    GROUP BY m.mapcfg
) words ON words.mapcfg = c.oid
WHERE c.cfgnamespace = ? AND 
      c.oid NOT IN (SELECT objid FROM extension_deps)