CREATE VIEW public.v2 AS
 SELECT t2.c1,
    t2.c2,
    t2.c4
   FROM public.t2;

ALTER TABLE public.v2 OWNER TO galiev_mr;