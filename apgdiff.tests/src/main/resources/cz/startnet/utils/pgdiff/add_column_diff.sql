SET search_path = public, pg_catalog;

ALTER TABLE testtable
	ADD COLUMN field5 boolean;

ALTER TABLE ONLY testtable
	ALTER COLUMN field5 SET DEFAULT false;

ALTER TABLE ONLY testtable
	ALTER COLUMN field5 SET NOT NULL;
