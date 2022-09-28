CREATE TABLE public.t1 (
    c1 integer,
    c2 text,
    c3 text,
    c4 integer,
    c5 integer,
    c6 text
);

ALTER TABLE public.t1 OWNER TO galiev_mr;

CREATE VIEW public.v8 AS
 SELECT v5.c1,
    v7.c2,
    t3.c3
   FROM public.v5,
    public.v7,
    public.t3;

ALTER TABLE public.v8 OWNER TO galiev_mr;