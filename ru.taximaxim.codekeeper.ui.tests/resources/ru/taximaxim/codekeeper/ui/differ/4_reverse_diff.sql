SET TIMEZONE TO 'UTC';

-- DEPCY: This SCHEMA is a dependency of TABLE: test_table

CREATE SCHEMA test;

ALTER SCHEMA test OWNER TO galiev_mr;

SET search_path = test, pg_catalog;

CREATE TABLE test_table (
	c1 integer,
	c2 integer,
	c3 text,
	c4 date,
	c5 integer
);

ALTER TABLE test_table OWNER TO galiev_mr;
