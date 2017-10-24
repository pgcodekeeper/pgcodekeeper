-- extension owned constraints are skipped by table != null check in java code

SELECT ccc.relname,
    c.conname,
    c.contype,
    cf.relname AS foreign_table_name,
    (SELECT nsp.nspname
     FROM pg_catalog.pg_namespace nsp
     WHERE nsp.oid = cf.relnamespace) AS foreign_schema_name,
    (SELECT array_agg(attname ORDER BY attnum) 
     FROM pg_attribute a
     WHERE a.attrelid = cf.oid AND a.attnum = ANY(c.confkey)) AS foreign_cols,
    (SELECT array_agg(attname ORDER BY attnum) 
     FROM pg_attribute a
     WHERE a.attrelid = ccc.oid AND a.attnum = ANY(c.conkey)) AS cols,
    d.description,
    pg_get_constraintdef(c.oid) as definition
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_constraint c ON ccc.oid = c.conrelid
LEFT JOIN pg_catalog.pg_class cf ON cf.oid = c.confrelid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
WHERE ccc.relkind IN ('r', 'p', 'f')
    AND c.contype != 't'
    AND ccc.relnamespace = ?