-- DEPCY: This object depends on the type we are about to drop: typ_range

DROP FUNCTION "add"(typ_range, integer);

DROP TYPE typ_range;

-- DEPCY: This object depends on the type we are about to create: typ_range

CREATE OR REPLACE FUNCTION "add"(typ_range, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION "add"(typ_range, integer) OWNER TO botov_av;

CREATE TYPE typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE typ_range OWNER TO botov_av;
