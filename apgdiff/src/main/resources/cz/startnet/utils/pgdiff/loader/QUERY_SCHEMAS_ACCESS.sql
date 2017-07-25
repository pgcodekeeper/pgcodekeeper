SELECT n.nspname
FROM pg_catalog.pg_namespace n
WHERE n.nspname NOT LIKE 'pg\_%'
    AND n.nspname != 'information_schema'
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e')
    AND pg_catalog.has_schema_privilege(n.nspname, 'USAGE')