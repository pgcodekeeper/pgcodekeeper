-- DEPCY: This FUNCTION depends on the TYPE: typ_composite

DROP FUNCTION add(typ_composite, integer);

ALTER TYPE typ_composite
	ALTER ATTRIBUTE key TYPE character varying(80) COLLATE pg_catalog."ru_RU", 
	ALTER ATTRIBUTE val TYPE text COLLATE pg_catalog."en_GB.utf8";

CREATE OR REPLACE FUNCTION add(typ_composite, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION add(typ_composite, integer) OWNER TO botov_av;
