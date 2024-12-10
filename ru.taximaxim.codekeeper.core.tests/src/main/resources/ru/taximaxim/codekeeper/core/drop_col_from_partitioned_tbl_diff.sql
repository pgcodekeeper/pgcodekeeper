SET search_path = pg_catalog;

ALTER TABLE public.cities
	DROP COLUMN bstat;

-- DEPCY: This COLUMN qwe depends on the COLUMN: public.cities.qwe

ALTER TABLE ONLY public.cities_ab_10000_to_100000
	ALTER COLUMN qwe DROP DEFAULT;

ALTER TABLE ONLY public.cities_ab
	ALTER COLUMN qwe DROP DEFAULT;

ALTER TABLE ONLY public.cities_partdef
	ALTER COLUMN qwe DROP DEFAULT;

ALTER TABLE public.cities
	DROP COLUMN qwe;