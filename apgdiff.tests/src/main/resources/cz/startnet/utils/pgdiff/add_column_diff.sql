SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD COLUMN field5 boolean;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field5 SET DEFAULT false;

UPDATE ONLY public.testtable
	SET field5 = DEFAULT WHERE field5 IS NULL;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field5 SET NOT NULL;
