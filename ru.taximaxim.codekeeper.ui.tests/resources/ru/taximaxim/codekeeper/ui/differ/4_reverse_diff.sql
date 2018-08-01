SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

-- DEPCY: This SCHEMA is a dependency of TABLE: test.test_table

CREATE SCHEMA test;

ALTER SCHEMA test OWNER TO galiev_mr;

CREATE TABLE test.test_table (
	c1 integer,
	c2 integer,
	c3 text,
	c4 date,
	c5 integer
);

ALTER TABLE test.test_table OWNER TO galiev_mr;
