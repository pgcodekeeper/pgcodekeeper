SET search_path = pg_catalog;

-- DEPCY: This SCHEMA collations is a dependency of TYPE: test.tt1

CREATE SCHEMA collations;

-- DEPCY: This COLLATION coll5 is a dependency of TYPE: test.tt1

CREATE COLLATION collations.coll5 (LOCALE = 'fr_FR.utf8');

CREATE TYPE test.tt1 AS RANGE (
	subtype = double precision,
	collation = collations.coll5,
	subtype_diff = float8mi
);

-- DEPCY: This COLLATION coll4 is a dependency of DOMAIN: test.d1

CREATE COLLATION collations.coll4 (LOCALE = 'fr_FR.utf8');

CREATE DOMAIN test.d1 AS TEXT COLLATE collations.coll4;

-- DEPCY: This COLLATION coll2 is a dependency of COLUMN: test.t1.c2

CREATE COLLATION collations.coll2 (LOCALE = 'fr_FR.utf8');

CREATE TABLE test.t1 (
	c1 integer,
	c2 text COLLATE collations.coll2
);

-- DEPCY: This COLLATION coll3 is a dependency of INDEX: test.i1

CREATE COLLATION collations.coll3 (LOCALE = 'fr_FR.utf8');

CREATE INDEX i1 ON test.t1 (c2 COLLATE collations.coll3);

-- DEPCY: This COLLATION coll1 is a dependency of VIEW: test.v1

CREATE COLLATION collations.coll1 (LOCALE = 'fr_FR.utf8');

CREATE VIEW test.v1 AS
	SELECT 'A' = 'A' COLLATE collations.coll1;