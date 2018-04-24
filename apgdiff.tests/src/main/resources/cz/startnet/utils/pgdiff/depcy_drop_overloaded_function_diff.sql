SET search_path = public, pg_catalog;

-- DEPCY: This VIEW depends on the FUNCTION: f(integer)

DROP VIEW v2;

DROP FUNCTION f(p integer);

-- DEPCY: This FUNCTION is a dependency of VIEW: v2

CREATE OR REPLACE FUNCTION f(p integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION f(p integer) OWNER TO shamsutdinov_lr;

CREATE VIEW v2 AS
	SELECT f(3) AS f;

ALTER VIEW v2 OWNER TO shamsutdinov_lr;
