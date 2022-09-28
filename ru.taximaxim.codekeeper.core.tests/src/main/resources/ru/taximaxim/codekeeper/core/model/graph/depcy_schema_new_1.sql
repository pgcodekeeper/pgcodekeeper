CREATE TABLE public.t1 (
    c1 text,
    c2 boolean
);

CREATE VIEW public.v2 AS
 SELECT a.c1
   FROM public.t1 a;

CREATE VIEW public.v1 AS
 SELECT a.c1
   FROM public.v2 a;

GRANT ALL ON SCHEMA public TO maindb;