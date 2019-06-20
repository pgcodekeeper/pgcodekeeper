CREATE VIEW public.v5 AS
 SELECT v2.c1,
    v3.c2,
    v4.c4
   FROM public.v2,
    public.v3,
    public.v4;

ALTER TABLE public.v5 OWNER TO galiev_mr;