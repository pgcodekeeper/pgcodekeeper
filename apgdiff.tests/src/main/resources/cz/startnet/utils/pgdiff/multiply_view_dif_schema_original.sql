create schema test_scm1;

SET search_path = public, pg_catalog;

CREATE TABLE t1 (
    c1 integer,
    c2 integer
);

SET search_path = test_scm1, pg_catalog;

CREATE TABLE t2 (
    c3 integer,
    c4 integer
);

SET search_path = public, pg_catalog;

CREATE VIEW v1 AS
 SELECT t1.c1,
    t1.c2,
    t2.c3
   FROM t1,
    test_scm1.t2;
