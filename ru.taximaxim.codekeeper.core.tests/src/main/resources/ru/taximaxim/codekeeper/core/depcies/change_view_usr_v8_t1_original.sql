CREATE TABLE public.t1 (
    c1 integer,
    c2 text,
    c3 text,
    c4 text,
    c5 integer
);

ALTER TABLE public.t1 OWNER TO galiev_mr;

CREATE VIEW public.v8 AS
 SELECT v5.c1,
    v7.c2
   FROM public.v5,
    public.v7;

ALTER TABLE public.v8 OWNER TO galiev_mr;