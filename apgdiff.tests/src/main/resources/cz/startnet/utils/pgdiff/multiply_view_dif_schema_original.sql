CREATE SCHEMA test_scm1;

CREATE TABLE public.t1 (
    c1 integer,
    c2 integer
);

CREATE TABLE test_scm1.t2 (
    c3 integer,
    c4 integer
);

CREATE VIEW public.v1 AS
 SELECT t1.c1,
    t1.c2,
    t2.c3
   FROM public.t1,
    test_scm1.t2;
