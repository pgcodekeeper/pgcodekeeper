DROP INDEX testindex;

-- DEPCY: This CONSTRAINT depends on the TABLE: testtable

ALTER TABLE testtable_2
	DROP CONSTRAINT testtable_2_c2_fkey;
