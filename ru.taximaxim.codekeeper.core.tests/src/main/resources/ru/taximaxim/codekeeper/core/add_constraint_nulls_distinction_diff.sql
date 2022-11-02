SET search_path = pg_catalog;

ALTER TABLE public.t1
	ADD CONSTRAINT uq_nulls_distinct UNIQUE NULLS DISTINCT (id);

ALTER TABLE public.t1
	ADD CONSTRAINT uq_nulls_not_distinct UNIQUE NULLS NOT DISTINCT (id);