CREATE VIEW public.v5 AS
    SELECT GROUPING(t1.c1) AS grouping_c1,
    t1.c1,
    t1.c2,
    sum(t1.c3) AS sum
   FROM public.t1
  GROUP BY GROUPING SETS ((t1.c1, t1.c2), (t1.c1), (t1.c2), ((public.foo())))
  ORDER BY t1.c1, t1.c2;
