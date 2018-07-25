SET search_path = pg_catalog;

ALTER FOREIGN TABLE public.testtable
	ADD COLUMN c1 integer;

ALTER FOREIGN TABLE ONLY public.testtable
	ALTER COLUMN c1 SET NOT NULL;
