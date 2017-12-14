CREATE SCHEMA IF NOT EXISTS pgcodekeeperhelper;

-- these functions only read pg_catalog metadata, so it's safe to expose them to PUBLIC
-- you may alter access rights as you need

GRANT USAGE ON SCHEMA pgcodekeeperhelper to PUBLIC;

-- you may remove functions from this schema 
-- doing so will impose performance penalty on reading corresponding object types

-- DO NOT ALTER the functions themselves or their signatures
-- doing so will most likely result in failures to read the DB schema using JDBC