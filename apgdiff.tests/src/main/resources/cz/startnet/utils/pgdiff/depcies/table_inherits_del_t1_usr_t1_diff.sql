SET search_path = pg_catalog;

-- DEPCY: This TABLE depends on the TABLE: t1

ALTER TABLE public.t2
	NO INHERIT t1;

DROP TABLE public.t1;