CREATE VIEW public.v3 AS
 SELECT t1.c1,
    t2.c2
   FROM public.t1,
    public.t2;

ALTER TABLE public.v3 OWNER TO galiev_mr;