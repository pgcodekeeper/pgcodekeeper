SET search_path = pg_catalog;

-- DEPCY: This FUNCTION foo is a dependency of VIEW: public.v5

CREATE OR REPLACE FUNCTION public.foo() RETURNS SETOF record
    LANGUAGE sql
    AS $$SELECT 1::int,2::int,'A'::text;$$;

CREATE TABLE public.t1 (
	c1 integer,
	c2 integer,
	c3 integer
);

CREATE VIEW public.v5 AS
	SELECT GROUPING(t1.c1) AS grouping_c1,
    t1.c1,
    t1.c2,
    sum(t1.c3) AS sum
   FROM public.t1
  GROUP BY GROUPING SETS ((t1.c1, t1.c2), (t1.c1), (t1.c2), ((public.foo())))
  ORDER BY t1.c1, t1.c2;