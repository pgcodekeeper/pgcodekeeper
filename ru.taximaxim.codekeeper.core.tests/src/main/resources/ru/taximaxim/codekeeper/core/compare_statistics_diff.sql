SET search_path = pg_catalog;

DROP STATISTICS public.s3;

CREATE STATISTICS public.s2 ON a, b FROM public.t1;

COMMENT ON STATISTICS public.s2 IS 'Улучшает оценку числа строк для планировщика';

ALTER STATISTICS public.s4 SET STATISTICS 1024;

ALTER STATISTICS public.s5 SET STATISTICS -1;

DROP STATISTICS public.s6;

DROP STATISTICS public.s7;

CREATE STATISTICS public.s6 ON func(a), b FROM public.t1;

ALTER STATISTICS public.s6 SET STATISTICS 1024;

CREATE STATISTICS public.s7 ON a, b FROM public.t2;