WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_catalog.pg_extension'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT d.oid::bigint,
       d.dictname,
       d.dictowner::bigint,
       t.tmplname,
       n.nspname,
       d.dictinitoption,
       des.description AS comment
FROM pg_catalog.pg_ts_dict d
LEFT JOIN pg_catalog.pg_ts_template t ON d.dicttemplate = t.oid
LEFT JOIN pg_catalog.pg_namespace n ON t.tmplnamespace = n.oid     
LEFT JOIN pg_catalog.pg_description des ON d.oid = des.objoid 
WHERE d.dictnamespace = ? AND 
      d.oid NOT IN (SELECT objid FROM extension_deps)