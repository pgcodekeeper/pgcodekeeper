SET search_path = public, pg_catalog;

DROP INDEX testindex2;

ALTER TABLE testtable
	DROP COLUMN field5;
