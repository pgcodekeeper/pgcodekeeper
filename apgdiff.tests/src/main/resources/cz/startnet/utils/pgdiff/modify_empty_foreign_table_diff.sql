SET search_path = public, pg_catalog;

ALTER FOREIGN TABLE testtable
	ADD COLUMN c1 integer;

ALTER FOREIGN TABLE ONLY testtable
	ALTER COLUMN c1 SET NOT NULL;
