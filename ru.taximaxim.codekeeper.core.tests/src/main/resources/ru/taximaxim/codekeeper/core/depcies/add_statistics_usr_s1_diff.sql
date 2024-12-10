SET search_path = pg_catalog;

CREATE TABLE first.t1 (
	a integer,
	b integer
);

-- DEPCY: This FUNCTION f1 is a dependency of STATISTICS: second.s1

CREATE OR REPLACE FUNCTION first.f1(f1 integer) RETURNS integer
    LANGUAGE plpgsql IMMUTABLE
    AS $$
BEGIN
  SELECT f1 + 1;
END;
$$;

CREATE STATISTICS second.s1 ON first.f1(b), a FROM first.t1;