SET search_path = pg_catalog;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 DROP NOT NULL;
