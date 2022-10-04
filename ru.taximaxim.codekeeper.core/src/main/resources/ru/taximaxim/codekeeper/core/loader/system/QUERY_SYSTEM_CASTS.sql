SELECT pg_catalog.format_type(c.castsource, null) AS source, 
       pg_catalog.format_type(c.casttarget, null) AS target, 
       c.castcontext
FROM pg_catalog.pg_cast c
WHERE c.oid <= ( SELECT datlastsysoid FROM pg_catalog.pg_database WHERE datname = pg_catalog.current_database())
