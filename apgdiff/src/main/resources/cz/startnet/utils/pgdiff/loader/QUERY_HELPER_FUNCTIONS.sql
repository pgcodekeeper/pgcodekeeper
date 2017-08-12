SELECT p.proname, 
        pg_catalog.has_function_privilege(p.oid, 'EXECUTE') function_access,
        pg_catalog.has_schema_privilege(n.oid, 'USAGE') schema_access
FROM pg_catalog.pg_proc p
JOIN pg_catalog.pg_namespace n ON n.oid = p.pronamespace
WHERE n.nspname = ?