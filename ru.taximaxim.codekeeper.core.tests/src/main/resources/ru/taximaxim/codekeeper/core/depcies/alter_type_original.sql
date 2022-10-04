CREATE TYPE public.ty1 AS ENUM (
    'a',
    'd'
);

ALTER TYPE public.ty1 OWNER TO botov_av;

CREATE TABLE public.t1 (
    c1 public.ty1
);

ALTER TABLE public.t1 OWNER TO botov_av;

CREATE VIEW public.v1 AS
 SELECT t1.c1
   FROM public.t1;

ALTER TABLE public.v1 OWNER TO botov_av;