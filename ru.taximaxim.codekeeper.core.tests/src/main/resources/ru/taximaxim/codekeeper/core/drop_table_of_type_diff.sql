SET search_path = pg_catalog;

ALTER TABLE public.testtable
	DROP CONSTRAINT testtable_pkey;

DROP TABLE public.testtable;
