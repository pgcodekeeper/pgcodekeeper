SET search_path = pg_catalog;

ALTER TABLE public.testtable
	DROP CONSTRAINT testtable_id_key;

ALTER TABLE public.testtable
	DROP CONSTRAINT testtable_value1_key;

ALTER TABLE public.testtable
	DROP CONSTRAINT uq_nulls;

ALTER TABLE public.testtable
	DROP CONSTRAINT uq_nulls1;

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable_id_key UNIQUE (id);

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable_value1_key UNIQUE NULLS NOT DISTINCT (value1);

ALTER TABLE public.testtable
	ADD CONSTRAINT uq_nulls UNIQUE (value2);

ALTER TABLE public.testtable
	ADD CONSTRAINT uq_nulls1 UNIQUE NULLS DISTINCT (value4);