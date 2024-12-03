SET search_path = pg_catalog;

-- DEPCY: This FUNCTION f1 is a dependency of STATISTICS: second.s2

CREATE OR REPLACE FUNCTION first.f1(f1 integer) RETURNS integer
    LANGUAGE plpgsql IMMUTABLE
    AS $$
BEGIN
  SELECT f1 + 1;
END;
$$;

CREATE TABLE first.t1 (
	a integer,
	b integer
);

-- DEPCY: This VIEW v1 is a dependency of STATISTICS: second.s2

CREATE MATERIALIZED VIEW first.v1 AS
	SELECT a, b from first.t1
WITH DATA;

CREATE STATISTICS second.s2 ON b, first.f1(a) FROM first.v1;