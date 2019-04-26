SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD COLUMN field5 boolean DEFAULT false NOT NULL;