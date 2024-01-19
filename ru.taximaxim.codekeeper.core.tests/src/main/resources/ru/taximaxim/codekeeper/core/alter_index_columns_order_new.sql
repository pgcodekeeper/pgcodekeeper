CREATE TABLE public.t1 (
    c1 integer,
    c2 integer,
    c3 integer
);

CREATE INDEX i1 ON public.t1 (c1, c3, c2);
