SET search_path = pg_catalog;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4 SET STATISTICS -1;
