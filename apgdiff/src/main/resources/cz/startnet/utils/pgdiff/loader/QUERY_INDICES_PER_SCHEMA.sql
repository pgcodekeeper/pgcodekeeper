SELECT ccc.relname AS table_name,
    i.indisunique,
    c.relname,
    (SELECT n.nspname
     FROM pg_catalog.pg_namespace n
     WHERE c.relnamespace = n.oid) namespace,
     i.indisclustered as isClustered,
    c.relowner,
    d.description AS comment,
    tabsp.spcname as table_space,
    definition
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_index i ON ccc.oid = i.indrelid
LEFT JOIN pg_catalog.pg_description d ON i.indexrelid = d.objoid
    AND d.objsubid = 0
LEFT JOIN pg_tablespace tabsp ON tabsp.oid = i.indexrelid
JOIN pg_catalog.pg_class c ON c.oid = i.indexrelid
LEFT JOIN pg_catalog.pg_tablespace tabsp ON tabsp.oid = c.reltablespace
LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = i.indexrelid,
pg_get_indexdef(c.oid) definition
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = ?
    AND i.indisprimary = FALSE
    AND i.indisexclusion = FALSE
    AND cons.conindid is NULL
ORDER BY relname