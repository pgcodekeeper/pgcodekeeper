SET search_path = public, pg_catalog;

ALTER TABLE testtable
	DROP CONSTRAINT testtable_pkey;

DROP TABLE testtable;
