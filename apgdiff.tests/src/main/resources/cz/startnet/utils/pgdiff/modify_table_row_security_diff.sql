SET search_path = public, pg_catalog;

ALTER TABLE testtable
	DROP COLUMN field4;

DROP TABLE testtable2;

CREATE TABLE testtable4 (
	id integer,
	field text
);

ALTER TABLE testtable4 ENABLE ROW LEVEL SECURITY;

ALTER TABLE ONLY testtable4 FORCE ROW LEVEL SECURITY;

ALTER TABLE ONLY testtable NO FORCE ROW LEVEL SECURITY;

ALTER TABLE testtable3 DISABLE ROW LEVEL SECURITY;
