CREATE TABLE public.t1 (
    c1 integer,
    c2 text
);

ALTER TABLE public.t1 OWNER TO botov_av;

REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;
GRANT ALL(c1, c2) ON TABLE public.t1 TO maindb;