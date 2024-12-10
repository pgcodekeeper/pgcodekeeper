SET search_path = pg_catalog;

-- DEPCY: This VIEW v1 depends on the COLUMN: public.t1.c1

DROP VIEW public.v1;

ALTER TABLE public.t1
	ALTER COLUMN c1 TYPE bigInt USING c1::bigInt; /* TYPE change - table: public.t1 original: integer new: bigInt */

ALTER TABLE test_scm1.t2
	ALTER COLUMN c4 TYPE bigInt USING c4::bigInt; /* TYPE change - table: test_scm1.t2 original: integer new: bigInt */

CREATE VIEW public.v1 AS
	SELECT t1.c1, test_scm1.t2.* FROM public.t1, test_scm1.t2;