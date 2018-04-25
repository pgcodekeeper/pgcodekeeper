SELECT datlastsysoid::bigint 
FROM pg_catalog.pg_database 
WHERE datname = pg_catalog.current_database();
