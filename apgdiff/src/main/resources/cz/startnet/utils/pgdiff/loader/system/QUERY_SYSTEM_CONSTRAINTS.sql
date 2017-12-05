SELECT  c.conname AS name, 
        n.nspname
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_constraint c ON ccc.oid = c.conrelid
LEFT JOIN pg_catalog.pg_namespace n ON ccc.relnamespace = n.oid
WHERE ccc.relkind IN ('f', 'r', 'p' )
    AND c.contype != 't'
    AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')