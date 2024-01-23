SET search_path = pg_catalog;

DROP INDEX public.i1;

CREATE INDEX i1 ON public.t1 (c1, c3, c2);