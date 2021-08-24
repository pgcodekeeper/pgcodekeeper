WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'
        OR EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e'
                AND dp.classid = 'pg_catalog.pg_namespace'::pg_catalog.regclass)
)

SELECT c.oid::bigint, 
    ccc.relname,
    c.conname,
    c.contype,
    cf.relname AS foreign_table_name,
    ts.spcname,
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
FROM pg_catalog.pg_constraint c
LEFT JOIN pg_catalog.pg_class ccc ON ccc.oid = c.conrelid
LEFT JOIN pg_catalog.pg_class cf ON cf.oid = c.confrelid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
    AND d.classoid = 'pg_catalog.pg_constraint'::pg_catalog.regclass
LEFT JOIN pg_catalog.pg_class ci ON ci.oid = c.conindid AND c.contype != 'f'
LEFT JOIN pg_catalog.pg_tablespace ts ON ts.oid = ci.reltablespace
WHERE ccc.relkind IN ('r', 'p', 'f')
    AND c.contype != 't'
    AND ccc.relnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND c.coninhcount = 0