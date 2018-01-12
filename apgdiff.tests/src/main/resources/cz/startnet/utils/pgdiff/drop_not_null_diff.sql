SET search_path = public, pg_catalog;

ALTER TABLE ONLY testtable
	ALTER COLUMN field3 DROP NOT NULL;
