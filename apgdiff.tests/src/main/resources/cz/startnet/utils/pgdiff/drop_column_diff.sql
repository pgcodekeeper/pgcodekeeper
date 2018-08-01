SET search_path = pg_catalog;

DROP INDEX public.testindex2;

ALTER TABLE public.testtable
	DROP COLUMN field5;
