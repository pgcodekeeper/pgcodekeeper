SET search_path = public, pg_catalog;

-- DEPCY: This CONSTRAINT depends on the INDEX: testindex

ALTER TABLE testtable_2
	DROP CONSTRAINT testtable_2_c2_fkey;

DROP INDEX testindex;
