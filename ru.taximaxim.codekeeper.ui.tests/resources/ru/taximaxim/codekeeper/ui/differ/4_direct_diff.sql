SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

-- DEPCY: This CONSTRAINT contr_testtable_c5 depends on the TABLE: test.test_table

ALTER TABLE test.test_table
	DROP CONSTRAINT contr_testtable_c5;

-- DEPCY: This INDEX test_table_c2_idx depends on the TABLE: test.test_table

DROP INDEX test.test_table_c2_idx;

-- DEPCY: This INDEX test_table_c1_idx depends on the TABLE: test.test_table

DROP INDEX test.test_table_c1_idx;

DROP TABLE test.test_table;