SET search_path = pg_catalog;

CREATE TABLE public.t2 (
	c1 integer,
	c2 text
);

ALTER TABLE public.t2 OWNER TO botov_av;

GRANT SELECT ON TABLE public.t2 TO levsha_aa;

GRANT INSERT(c1),REFERENCES(c1),UPDATE(c1) ON TABLE public.t2 TO levsha_aa;

GRANT INSERT(c2) ON TABLE public.t2 TO levsha_aa;

GRANT SELECT ON TABLE public.t1 TO levsha_aa;

ALTER TABLE public.t1
	ADD COLUMN c2 text;

GRANT ALL(c2) ON TABLE public.t1 TO maindb;

GRANT INSERT(c2) ON TABLE public.t1 TO levsha_aa;

REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;

GRANT ALL(c1) ON TABLE public.t1 TO maindb;

GRANT INSERT(c1),REFERENCES(c1),UPDATE(c1) ON TABLE public.t1 TO levsha_aa;

CREATE VIEW public.v1 AS
	SELECT t1.c1
   FROM public.t1;

ALTER VIEW public.v1 OWNER TO botov_av;

REVOKE ALL(c1) ON TABLE public.v1 FROM levsha_aa;

GRANT UPDATE(c1) ON TABLE public.v1 TO maindb;