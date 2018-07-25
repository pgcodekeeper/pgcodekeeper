SET search_path = pg_catalog;

CREATE TABLE public.t1 (
	c1 integer,
	c2 text
);

ALTER TABLE public.t1 OWNER TO botov_av;

-- TABLE public.t1 GRANT

GRANT ALL ON TABLE public.t1 TO PUBLIC;

-- COLUMN public.t1.c1 GRANT

REVOKE ALL(c1) ON TABLE public.t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;
GRANT ALL(c1) ON TABLE public.t1 TO maindb;

-- COLUMN public.t1.c2 GRANT

GRANT ALL(c2) ON TABLE public.t1 TO maindb;