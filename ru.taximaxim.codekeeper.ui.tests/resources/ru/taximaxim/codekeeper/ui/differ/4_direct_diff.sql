SET TIMEZONE TO 'UTC';

SET search_path = test, pg_catalog;

-- DEPCY: This CONSTRAINT depends on the TABLE: test_table

ALTER TABLE test_table
	DROP CONSTRAINT contr_testtable_c5;

-- DEPCY: This INDEX depends on the TABLE: test_table

DROP INDEX test_table_c2_idx;

-- DEPCY: This INDEX depends on the TABLE: test_table

DROP INDEX test_table_c1_idx;

DROP TABLE test_table;
