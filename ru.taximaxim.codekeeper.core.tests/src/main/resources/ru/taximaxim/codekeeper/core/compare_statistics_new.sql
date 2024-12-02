CREATE TABLE public.t1 (a integer, b integer);
CREATE TABLE public.t2 (a integer, b integer);

CREATE STATISTICS public.s1 ON a, b FROM public.t1;

CREATE STATISTICS public.s2 ON a, b FROM public.t1;

COMMENT ON STATISTICS public.s2 IS 'Улучшает оценку числа строк для планировщика';

CREATE STATISTICS public.s4 ON a, b FROM public.t1;

ALTER STATISTICS public.s4 SET STATISTICS 1024;

CREATE STATISTICS public.s5 ON a, b FROM public.t1;

CREATE STATISTICS public.s6 ON func(a), b FROM public.t1;

ALTER STATISTICS public.s6 SET STATISTICS 1024;

CREATE STATISTICS public.s7 ON a, b FROM public.t2;