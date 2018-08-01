SET search_path = pg_catalog;

ALTER TABLE public.t1
	ADD COLUMN c2 text;

-- COLUMN public.t1.c2 GRANT

GRANT ALL(c2) ON TABLE public.t1 TO maindb;

-- COLUMN public.t1.c1 GRANT

REVOKE ALL(c1) ON TABLE public.t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;
GRANT ALL(c1) ON TABLE public.t1 TO maindb;
