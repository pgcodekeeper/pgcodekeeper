SET search_path = pg_catalog;

ALTER TABLE public.testtable
	DROP CONSTRAINT testtable_pkey;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field1 DROP NOT NULL;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 DROP DEFAULT;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field2 SET DEFAULT 5000;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4 DROP DEFAULT;

ALTER TABLE public.testtable
	ALTER COLUMN field4 SET NOT NULL;
