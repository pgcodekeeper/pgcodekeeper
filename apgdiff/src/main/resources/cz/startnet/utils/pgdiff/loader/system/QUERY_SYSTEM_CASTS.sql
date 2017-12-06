SELECT format_type(c.castsource, null) AS source, 
       format_type(c.casttarget, null) AS target, 
       c.castcontext
FROM pg_cast c
WHERE c.oid <= ( SELECT datlastsysoid FROM pg_database WHERE datname = current_database())
