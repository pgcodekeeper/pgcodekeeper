CREATE VIEW public.v6 AS
 SELECT v2.c1,
    v2.c2
   FROM public.v2;

ALTER TABLE public.v6 OWNER TO galiev_mr;