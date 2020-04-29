CREATE TABLE public.t1 (
    c1 integer,
    c2 integer,
    c3 integer,
    c4 integer
);

ALTER TABLE public.t1 OWNER TO postgres;

GRANT SELECT ON TABLE public.t1 TO test;