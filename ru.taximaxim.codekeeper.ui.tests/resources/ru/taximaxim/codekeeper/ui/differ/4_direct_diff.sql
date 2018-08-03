SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

-- DEPCY: This CONSTRAINT depends on the TABLE: test.test_table

ALTER TABLE test.test_table
	DROP CONSTRAINT contr_testtable_c5;

-- DEPCY: This INDEX depends on the TABLE: test.test_table

DROP INDEX test.test_table_c2_idx;

-- DEPCY: This INDEX depends on the TABLE: test.test_table

DROP INDEX test.test_table_c1_idx;

DROP TABLE test.test_table;
