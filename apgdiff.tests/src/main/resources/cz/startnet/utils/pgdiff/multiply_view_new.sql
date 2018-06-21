CREATE TABLE public.t1 (
    c1 bigInt,
    c2 integer
);

CREATE TABLE public.t2 (
    c3 integer,
    c4 bigInt
);

CREATE VIEW public.v1 AS
    SELECT * FROM public.t1, (SELECT * FROM public.t2) q1;
    