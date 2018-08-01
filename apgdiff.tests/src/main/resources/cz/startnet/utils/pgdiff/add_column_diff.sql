SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD COLUMN field5 boolean;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field5 SET DEFAULT false;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field5 SET NOT NULL;
