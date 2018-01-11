SET search_path = public, pg_catalog;

ALTER TABLE ONLY testtable
	ALTER COLUMN field4 DROP DEFAULT;
