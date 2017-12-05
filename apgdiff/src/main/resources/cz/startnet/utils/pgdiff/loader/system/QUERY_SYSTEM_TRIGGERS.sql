SELECT t.tgname AS name, 
       n.nspname
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
LEFT JOIN pg_catalog.pg_namespace n ON ccc.relnamespace = n.oid
WHERE ccc.relkind IN ('r', 'f', 'p', 'v', 'm')
   AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')
   AND tgisinternal = FALSE