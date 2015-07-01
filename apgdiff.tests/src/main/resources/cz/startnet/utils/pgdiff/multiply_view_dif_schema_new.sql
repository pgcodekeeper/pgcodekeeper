create schema test_scm1;

SET search_path = public, pg_catalog;

CREATE TABLE t1 (
    c1 bigInt,
    c2 integer
);

SET search_path = test_scm1, pg_catalog;

CREATE TABLE t2 (
    c3 integer,
    c4 bigInt
);

SET search_path = public, pg_catalog;

CREATE VIEW v1 AS
    select t1.c1, test_scm1.t2.* from t1, test_scm1.t2;