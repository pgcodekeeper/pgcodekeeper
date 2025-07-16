SET search_path = pg_catalog;

ALTER TABLE public.t1
	DROP CONSTRAINT c1;

ALTER TABLE public.testtable2
	DROP CONSTRAINT testtable4_pk;

ALTER TABLE public.testtable4
	DROP CONSTRAINT testtable4_pk;

ALTER TABLE public.test_fk_1
	DROP CONSTRAINT fk;

ALTER TABLE public.test_fk_2
	DROP CONSTRAINT fk_2;

ALTER TABLE public.test_fk_3
	DROP CONSTRAINT fk_3;

ALTER TABLE public.t1
	ADD CONSTRAINT c1 EXCLUDE USING gist (b WITH &&, a WITH &&);

ALTER TABLE public.testtable2
	ADD CONSTRAINT testtable4_pk PRIMARY KEY (col1, col2) INCLUDE (col4, col3);

ALTER TABLE public.testtable4
	ADD CONSTRAINT testtable4_pk PRIMARY KEY (col2, col1);

ALTER TABLE public.test_fk_1
	ADD CONSTRAINT fk FOREIGN KEY (col1, col2) REFERENCES public.test_pk(col2, col1);

ALTER TABLE public.test_fk_2
	ADD CONSTRAINT fk_2 FOREIGN KEY (col2, col1) REFERENCES public.test_pk(col1, col2);

ALTER TABLE public.test_fk_3
	ADD CONSTRAINT fk_3 FOREIGN KEY (col1, col2) REFERENCES public.test_pk(col1, col2) ON DELETE SET NULL(col2, col1);
