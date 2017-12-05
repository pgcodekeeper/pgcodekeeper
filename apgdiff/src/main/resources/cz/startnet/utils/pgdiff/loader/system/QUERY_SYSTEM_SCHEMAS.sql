SELECT n.nspname
FROM pg_catalog.pg_namespace n
WHERE n.nspname LIKE 'pg\_%'
    OR n.nspname = 'information_schema'