CREATE SCHEMA test_scm1;

CREATE TABLE public.t1 (
    c1 bigInt,
    c2 integer
);

CREATE TABLE test_scm1.t2 (
    c3 integer,
    c4 bigInt
);

CREATE VIEW public.v1 AS
    SELECT t1.c1, test_scm1.t2.* FROM public.t1, test_scm1.t2;