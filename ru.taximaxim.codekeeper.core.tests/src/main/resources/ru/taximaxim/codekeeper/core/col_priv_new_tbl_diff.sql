SET search_path = pg_catalog;

CREATE TABLE public.t1 (
	c1 integer,
	c2 text
);

ALTER TABLE public.t1 OWNER TO botov_av;

GRANT ALL ON TABLE public.t1 TO PUBLIC;

REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;

GRANT ALL(c1) ON TABLE public.t1 TO maindb;

GRANT ALL(c2) ON TABLE public.t1 TO maindb;