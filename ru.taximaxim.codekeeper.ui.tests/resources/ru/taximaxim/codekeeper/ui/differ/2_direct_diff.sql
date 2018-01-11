SET TIMEZONE TO 'UTC';

SET search_path = public, pg_catalog;

ALTER TABLE t1
	DROP CONSTRAINT t1_c2_key;

ALTER TABLE t1
	ADD CONSTRAINT t1_c2_key UNIQUE (c1, c2);
