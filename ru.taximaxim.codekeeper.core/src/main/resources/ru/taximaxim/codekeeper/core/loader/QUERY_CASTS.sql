WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE dep.classid = 'pg_catalog.pg_cast'::pg_catalog.regclass
        AND dep.deptype = 'e'
)

SELECT
    c.oid::bigint,
    pg_catalog.format_type(c.castsource, null) AS source, 
    pg_catalog.format_type(c.casttarget, null) AS target,
    c.castfunc::regprocedure AS func,
    c.castcontext,
    c.castmethod,
    d.description
FROM pg_cast c
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
    AND d.classoid = 'pg_catalog.pg_cast'::pg_catalog.regclass
WHERE c.oid > (SELECT datlastsysoid FROM pg_catalog.pg_database WHERE datname = pg_catalog.current_database())
    AND c.oid NOT IN (SELECT objid FROM extension_deps)