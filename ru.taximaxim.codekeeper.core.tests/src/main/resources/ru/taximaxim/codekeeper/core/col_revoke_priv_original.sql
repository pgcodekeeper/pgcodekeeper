CREATE TABLE public.t1 (
    c1 integer
);

ALTER TABLE public.t1 OWNER TO botov_av;

REVOKE ALL(c1) ON TABLE public.t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE public.t1 FROM botov_av;
GRANT ALL(c1) ON TABLE public.t1 TO maindb;