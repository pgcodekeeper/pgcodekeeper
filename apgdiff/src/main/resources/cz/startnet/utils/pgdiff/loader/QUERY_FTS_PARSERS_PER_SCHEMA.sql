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

SELECT p.oid::bigint,
       p.prsname,
       p.prsstart,
       p.prstoken,
       p.prsend,
       p.prsheadline,
       p.prslextype,
       d.description AS comment,
       p.prsnamespace AS schema_oid
FROM pg_catalog.pg_ts_parser p    
LEFT JOIN pg_catalog.pg_description d ON p.oid = d.objoid
WHERE p.prsnamespace NOT IN (SELECT oid FROM sys_schemas)  
    AND p.oid NOT IN (SELECT objid FROM extension_deps)