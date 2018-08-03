SET search_path = pg_catalog;

CREATE TABLE public.t2 (
	c1 integer,
	c2 text
);

ALTER TABLE public.t2 OWNER TO botov_av;

-- TABLE public.t2 GRANT

GRANT SELECT ON TABLE public.t2 TO levsha_aa;

-- COLUMN public.t2.c1 GRANT

GRANT INSERT(c1), REFERENCES(c1), UPDATE(c1) ON TABLE public.t2 TO levsha_aa;

-- COLUMN public.t2.c2 GRANT

GRANT INSERT(c2) ON TABLE public.t2 TO levsha_aa;

-- TABLE public.t1 GRANT

GRANT SELECT ON TABLE public.t1 TO levsha_aa;

ALTER TABLE public.t1
	ADD COLUMN c2 text;

-- COLUMN public.t1.c2 GRANT

GRANT ALL(c2) ON TABLE public.t1 TO maindb;
GRANT INSERT(c2) ON TABLE public.t1 TO levsha_aa;

-- COLUMN public.t1.c1 GRANT

REVOKE ALL(c1) ON TABLE public.t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;
GRANT ALL(c1) ON TABLE public.t1 TO maindb;
GRANT INSERT(c1), REFERENCES(c1), UPDATE(c1) ON TABLE public.t1 TO levsha_aa;

CREATE VIEW public.v1 AS
	SELECT t1.c1
   FROM public.t1;

-- VIEW public.v1 GRANT

REVOKE ALL(c1) ON TABLE public.v1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE public.v1 FROM levsha_aa;
GRANT UPDATE(c1) ON TABLE public.v1 TO maindb;
