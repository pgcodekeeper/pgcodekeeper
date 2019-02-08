CREATE VIEW public.v6 AS
 SELECT v2.c1,
    v2.c2,
    t1.c6
   FROM public.v2,
    public.t1;

ALTER TABLE public.v6 OWNER TO galiev_mr;