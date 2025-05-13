SET search_path = pg_catalog;

-- DEPCY: This CONSTRAINT test_fk_1_col1_fkey depends on the CONSTRAINT: public.test_t1.test_t1_pkey

ALTER TABLE public.test_fk_1
	DROP CONSTRAINT test_fk_1_col1_fkey;

ALTER TABLE public.test_t1
	DROP CONSTRAINT test_t1_pkey;

ALTER TABLE public.test_t1
	ADD CONSTRAINT test_t1_pkey PRIMARY KEY (id) WITH (fillfactor='10');

ALTER TABLE public.test_fk_1
	ADD CONSTRAINT test_fk_1_col1_fkey FOREIGN KEY (col1) REFERENCES public.test_t1(id) ON UPDATE CASCADE ON DELETE SET NULL;