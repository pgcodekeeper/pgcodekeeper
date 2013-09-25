CREATE SCHEMA postgis;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA postgis;

COMMENT ON EXTENSION postgis IS 'PostGIS geometry, geography, and raster spatial types and functions';


CREATE TABLE contacts(id int PRIMARY KEY, number_pool_id int, name varchar(50));

CREATE INDEX contacts_number_pool_id_idx ON contacts(number_pool_id);
