SET search_path = public, pg_catalog;

ALTER DOMAIN dom1
	VALIDATE CONSTRAINT dom1_check;

ALTER TABLE t1
	VALIDATE CONSTRAINT t1_c1_check;