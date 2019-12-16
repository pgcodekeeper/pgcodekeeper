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

SELECT 
   c.oid,
   columns.col_generated
FROM pg_catalog.pg_class c
LEFT JOIN (SELECT
            a.attrelid,
           pg_catalog.array_agg(a.attgenerated ORDER BY a.attnum) AS col_generated
      FROM pg_catalog.pg_attribute a
      WHERE a.attisdropped IS FALSE
            AND a.attnum > 0 
      GROUP BY attrelid) columns ON columns.attrelid = c.oid