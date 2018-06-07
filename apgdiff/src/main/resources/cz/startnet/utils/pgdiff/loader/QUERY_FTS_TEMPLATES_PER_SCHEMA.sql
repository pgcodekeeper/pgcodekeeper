WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_catalog.pg_extension'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT t.tmplname,
       t.tmplinit,
       t.tmpllexize,
       d.description AS comment
FROM pg_catalog.pg_ts_template t   
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid 
WHERE t.tmplnamespace = ? AND 
      t.oid NOT IN (SELECT objid FROM extension_deps)