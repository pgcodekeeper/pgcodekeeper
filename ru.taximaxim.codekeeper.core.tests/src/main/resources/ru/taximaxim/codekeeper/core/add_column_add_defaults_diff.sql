SET search_path = pg_catalog;

ALTER TABLE public.table1
	ADD COLUMN col2 integer NOT NULL;

ALTER TABLE public.table1
	ADD COLUMN col3 integer DEFAULT 5 NOT NULL;