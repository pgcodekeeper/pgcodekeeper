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

SELECT t.oid::bigint,
       t.tmplname,
       t.tmplinit,
       t.tmpllexize,
       d.description AS comment,
       t.tmplnamespace AS schema_oid
FROM pg_catalog.pg_ts_template t   
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid 
WHERE t.tmplnamespace NOT IN (SELECT oid FROM sys_schemas) 
    AND t.oid NOT IN (SELECT objid FROM extension_deps)