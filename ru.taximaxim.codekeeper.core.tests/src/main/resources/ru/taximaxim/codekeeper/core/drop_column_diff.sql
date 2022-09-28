SET search_path = pg_catalog;

DROP INDEX public.testindex2;

ALTER TABLE ONLY public.testtable
	DROP COLUMN field5;
