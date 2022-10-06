WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'
), extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE dep.classid = 'pg_catalog.pg_collation'::pg_catalog.regclass AND dep.deptype = 'e'
)

SELECT
    c.oid::bigint,
    c.collnamespace AS schema_oid,
    c.collname,
    c.collcollate,
    c.collctype,
    c.collowner::bigint,
    c.collprovider,
    d.description AS comment
FROM pg_catalog.pg_collation c
    LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
WHERE c.collnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND c.oid NOT IN (SELECT objid FROM extension_deps)
