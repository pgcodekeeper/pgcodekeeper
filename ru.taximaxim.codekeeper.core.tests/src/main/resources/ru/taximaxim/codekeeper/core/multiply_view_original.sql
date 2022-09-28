CREATE TABLE public.t1 (
    c1 integer,
    c2 integer
);

CREATE TABLE public.t2 (
    c3 integer,
    c4 integer
);

CREATE VIEW public.v1 AS
    SELECT t1.c1,
    t1.c2,
    q1.c3,
    q1.c4
   FROM public.t1,
    ( SELECT t2.c3,
            t2.c4
           FROM public.t2) q1;