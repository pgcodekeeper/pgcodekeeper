SET search_path = pg_catalog;

ALTER TABLE public.t2
	NO INHERIT public.t1;

ALTER TABLE public.t2
	ADD COLUMN c1 integer;
