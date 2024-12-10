SET search_path = pg_catalog;

-- DEPCY: This TABLE t2 depends on the TABLE: public.t1

ALTER TABLE public.t2
	NO INHERIT public.t1;

DROP TABLE public.t1;