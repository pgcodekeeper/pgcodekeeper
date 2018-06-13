SELECT n.nspname, 
       EXISTS (SELECT 1 FROM pg_catalog.pg_event_trigger 
               WHERE evtenabled != 'O' 
               AND (evtname = 'dbots_tg_on_ddl_event' OR evtname = 'dbots_tg_on_drop_event')) AS disabled
FROM pg_catalog.pg_namespace n
LEFT JOIN pg_catalog.pg_extension e on e.extnamespace = n.oid
WHERE extname = 'pg_dbo_timestamp'