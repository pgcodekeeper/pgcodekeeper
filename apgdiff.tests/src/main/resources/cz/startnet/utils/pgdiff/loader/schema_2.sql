CREATE SCHEMA postgis;

CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA postgis;

COMMENT ON EXTENSION postgis IS 'PostGIS geometry, geography, and raster spatial types and functions';

CREATE TABLE public.contacts(id int, number_pool_id int, name varchar(50));

CREATE INDEX contacts_number_pool_id_idx ON public.contacts(number_pool_id);
