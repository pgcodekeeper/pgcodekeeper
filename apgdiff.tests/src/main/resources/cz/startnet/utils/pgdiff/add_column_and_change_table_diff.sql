SET search_path = pg_catalog;

REVOKE ALL ON TABLE public.t1 FROM PUBLIC;
REVOKE ALL ON TABLE public.t1 FROM postgres;
GRANT ALL ON TABLE public.t1 TO postgres;

GRANT SELECT ON TABLE public.t1 TO test;

ALTER TABLE public.t1
	ADD COLUMN c2 integer;

ALTER TABLE public.t1
	ADD COLUMN c3 integer;

ALTER TABLE public.t1
	ADD COLUMN c4 integer;