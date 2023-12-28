CREATE SCHEMA test;

CREATE VIEW test.v1 AS 
  SELECT 'A' = 'A' COLLATE collations.coll1;

CREATE TABLE test.t1 (c1 integer, c2 text COLLATE collations.coll2);

CREATE INDEX i1 ON test.t1 (c2 COLLATE collations.coll3);

CREATE DOMAIN test.d1 AS TEXT COLLATE collations.coll4;

CREATE TYPE test.tt1 AS RANGE (subtype = float8, subtype_diff = float8mi, COLLATION = collations.coll5);