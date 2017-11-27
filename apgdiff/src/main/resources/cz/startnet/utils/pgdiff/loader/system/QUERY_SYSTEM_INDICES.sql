SELECT  cls.relname AS name, 
        n.nspname
FROM pg_catalog.pg_index ind
JOIN pg_catalog.pg_class cls ON cls.oid = ind.indexrelid
LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = ind.indexrelid AND cons.contype IN ('p', 'u', 'x')
LEFT JOIN pg_catalog.pg_namespace n ON cls.relnamespace = n.oid
WHERE cls.relkind = 'i'
    AND ind.indisprimary = FALSE
    AND ind.indisexclusion = FALSE
    AND cons.conindid is NULL
    AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')