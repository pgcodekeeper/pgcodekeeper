SET search_path = pg_catalog;

DROP EXTENSION postgis;

-- DEPCY: This SCHEMA test is a dependency of EXTENSION: postgis

CREATE SCHEMA test;

CREATE EXTENSION postgis SCHEMA test;