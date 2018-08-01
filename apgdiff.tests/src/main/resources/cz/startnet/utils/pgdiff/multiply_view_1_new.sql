CREATE TABLE public.t1 (
    c1 bigInt,
    c2 integer
);

CREATE TABLE public.t2 (
    c3 integer,
    c4 bigInt
);

CREATE VIEW public.v1 AS
    SELECT t1.*, t2.c3 FROM public.t1, public.t2;