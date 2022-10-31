SET search_path = pg_catalog;

DROP INDEX public.index1;

DROP INDEX public.index2;

CREATE INDEX index1 ON public.table1 (id) NULLS NOT DISTINCT;

CREATE INDEX index2 ON public.table2 (id);