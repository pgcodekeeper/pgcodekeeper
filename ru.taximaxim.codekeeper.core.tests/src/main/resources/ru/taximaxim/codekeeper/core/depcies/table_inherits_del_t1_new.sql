CREATE TABLE public.t2 (
    c1 integer,
    c2 integer
);

ALTER TABLE public.t2 OWNER TO botov_av;

CREATE VIEW public.v1 AS
 SELECT t2.c1,
    t2.c2
   FROM public.t2;

ALTER TABLE public.v1 OWNER TO botov_av;