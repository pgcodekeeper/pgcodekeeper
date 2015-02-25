DROP FUNCTION "add"(typ_composite, integer);

DROP TYPE typ_composite;

-- DEPCY: This object depends on the type we are about to create: typ_composite

CREATE OR REPLACE FUNCTION "add"(typ_composite, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION "add"(typ_composite, integer) OWNER TO botov_av;
