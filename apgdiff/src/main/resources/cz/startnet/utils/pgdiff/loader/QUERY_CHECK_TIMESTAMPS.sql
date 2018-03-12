SELECT n.nspname 
FROM pg_catalog.pg_namespace n
LEFT JOIN pg_catalog.pg_extension e on e.extnamespace = n.oid
WHERE extname = 'pg_dbo_timestamp'