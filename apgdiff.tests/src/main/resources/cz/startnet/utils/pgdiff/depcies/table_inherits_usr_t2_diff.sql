SET search_path = public, pg_catalog;

ALTER TABLE t2
	NO INHERIT t1;

ALTER TABLE t2
	ADD COLUMN c1 integer;
