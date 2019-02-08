CREATE TYPE public.typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU.utf8"
);

ALTER TYPE public.typ_range OWNER TO botov_av;

CREATE FUNCTION public.add(public.typ_range, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION public.add(public.typ_range, integer) OWNER TO botov_av;