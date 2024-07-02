CREATE SCHEMA first;

CREATE SCHEMA second;

CREATE TABLE first.t1 (a integer, b integer);

CREATE MATERIALIZED VIEW first.v1 AS SELECT a, b from first.t1;

CREATE OR REPLACE FUNCTION first.f1(f1 integer) RETURNS integer
    LANGUAGE plpgsql IMMUTABLE
    AS $$
BEGIN
  SELECT f1 + 1;
END;
$$;

CREATE STATISTICS second.s1 ON first.f1(b), a FROM first.t1;

CREATE STATISTICS second.s2 ON b, first.f1(a) FROM first.v1;