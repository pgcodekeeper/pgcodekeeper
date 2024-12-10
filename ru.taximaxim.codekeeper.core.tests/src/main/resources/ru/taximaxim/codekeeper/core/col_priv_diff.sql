SET search_path = pg_catalog;

ALTER TABLE public.t1
	ADD COLUMN c2 text;

GRANT ALL(c2) ON TABLE public.t1 TO maindb;

REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;

GRANT ALL(c1) ON TABLE public.t1 TO maindb;
