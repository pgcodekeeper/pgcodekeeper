SET search_path = pg_catalog;

-- DEPCY: This CONSTRAINT testtable_2_c2_fkey depends on the INDEX: public.testindex

ALTER TABLE public.testtable_2
	DROP CONSTRAINT testtable_2_c2_fkey;

DROP INDEX public.testindex;