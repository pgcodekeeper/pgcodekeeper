CREATE VIEW public.v4 AS
 SELECT v1.c1,
    v3.c2,
    t1.c3
   FROM public.v1,
    public.v3,
    public.t1;

ALTER TABLE public.v4 OWNER TO galiev_mr;