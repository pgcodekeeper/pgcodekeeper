WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'
        OR EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e')
)

SELECT ccc.oid::bigint, 
    ccc.relname,
    c.conname,
    c.contype,
    cf.relname AS foreign_table_name,
    (SELECT nsp.nspname
     FROM pg_catalog.pg_namespace nsp
     WHERE nsp.oid = cf.relnamespace) AS foreign_schema_name,
    (SELECT pg_catalog.array_agg(attname ORDER BY attnum) 
     FROM pg_catalog.pg_attribute a
     WHERE a.attrelid = cf.oid AND a.attnum = ANY(c.confkey)) AS foreign_cols,
    (SELECT pg_catalog.array_agg(attname ORDER BY attnum) 
     FROM pg_catalog.pg_attribute a
     WHERE a.attrelid = ccc.oid AND a.attnum = ANY(c.conkey)) AS cols,
    d.description,
    pg_catalog.pg_get_constraintdef(c.oid) AS definition,
    ccc.relnamespace AS schema_oid
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_constraint c ON (ccc.oid = c.conrelid AND c.coninhcount = 0)
LEFT JOIN pg_catalog.pg_class cf ON cf.oid = c.confrelid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
WHERE ccc.relkind IN ('r', 'p', 'f')
    AND c.contype != 't'
    AND ccc.relnamespace NOT IN (SELECT oid FROM sys_schemas)