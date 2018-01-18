SET search_path = public, pg_catalog;

-- DEPCY: This TABLE depends on the TABLE: t1

ALTER TABLE t2
	NO INHERIT t1;

DROP TABLE t1;