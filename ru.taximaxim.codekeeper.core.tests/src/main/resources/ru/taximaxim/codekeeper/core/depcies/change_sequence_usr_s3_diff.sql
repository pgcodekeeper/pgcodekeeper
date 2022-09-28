SET search_path = pg_catalog;

-- DEPCY: This COLUMN depends on the SEQUENCE: public.s3

ALTER TABLE ONLY public.t3
	ALTER COLUMN c1 DROP DEFAULT;

DROP SEQUENCE public.s3;
