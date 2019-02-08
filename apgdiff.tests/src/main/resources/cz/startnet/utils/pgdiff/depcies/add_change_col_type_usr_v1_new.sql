CREATE VIEW public.v1 AS
 SELECT t1.c1,
    t2.c2,
    'asdad' AS text
   FROM public.t1,
    public.t2;

ALTER TABLE public.v1 OWNER TO botov_av;

COMMENT ON VIEW public.v1 IS 'asdsada';