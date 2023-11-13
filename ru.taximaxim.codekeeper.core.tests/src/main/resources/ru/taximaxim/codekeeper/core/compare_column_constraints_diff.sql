SET search_path = pg_catalog;

ALTER TABLE public.testtable2
	DROP CONSTRAINT check_positive;

ALTER TABLE public.testtable3
	DROP CONSTRAINT testtable3_id_key;

ALTER TABLE public.testtable3
	DROP CONSTRAINT testtable3_value1_key;

ALTER TABLE public.testtable3
	DROP CONSTRAINT uq_nulls;

ALTER TABLE public.testtable3
	DROP CONSTRAINT uq_nulls1;

ALTER TABLE public.testtable2
	ADD CONSTRAINT check_positive CHECK ((c4 > 0)) NO INHERIT;

ALTER TABLE public.testtable3
	ADD CONSTRAINT testtable3_id_key UNIQUE (id);

ALTER TABLE public.testtable3
	ADD CONSTRAINT testtable3_value1_key UNIQUE NULLS NOT DISTINCT (value1);

ALTER TABLE public.testtable3
	ADD CONSTRAINT uq_nulls UNIQUE (value2);

ALTER TABLE public.testtable3
	ADD CONSTRAINT uq_nulls1 UNIQUE (value4) WITH (fillfactor=70);
