CREATE VIEW public.v8 AS
 SELECT v5.c1,
    v7.c2,
    t3.c3
   FROM public.v5,
    public.v7,
    public.t3;

ALTER TABLE public.v8 OWNER TO galiev_mr;