SET search_path = pg_catalog;

GRANT SELECT ON TABLE public.t1 TO test;

ALTER TABLE public.t1
	ADD COLUMN c2 integer;

ALTER TABLE public.t1
	ADD COLUMN c3 integer;

ALTER TABLE public.t1
	ADD COLUMN c4 integer;