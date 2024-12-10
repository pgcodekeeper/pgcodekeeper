SET search_path = pg_catalog;

-- DEPCY: This FUNCTION add depends on the TYPE: public.typ_range

DROP FUNCTION public.add(public.typ_range, integer);

DROP TYPE public.typ_range;

-- DEPCY: This TYPE typ_range is a dependency of FUNCTION: public.add(public.typ_range, integer)

CREATE TYPE public.typ_range AS RANGE (
	subtype = character varying,
	collation = pg_catalog."ru_RU"
);

ALTER TYPE public.typ_range OWNER TO botov_av;

CREATE OR REPLACE FUNCTION public.add(public.typ_range, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION public.add(public.typ_range, integer) OWNER TO botov_av;