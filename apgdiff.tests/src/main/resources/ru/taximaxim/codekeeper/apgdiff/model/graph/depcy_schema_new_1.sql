CREATE TABLE public.t1 (
    c1 text,
    c2 boolean
);

CREATE VIEW public.v2 AS
 SELECT a.c1
   FROM t1 a;

CREATE VIEW public.v1 AS
 SELECT a.c1
   FROM v2 a;

GRANT ALL ON SCHEMA public.public TO maindb;