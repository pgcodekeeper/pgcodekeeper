CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);

ALTER TYPE public.typ_composite OWNER TO botov_av;

CREATE FUNCTION public.add(public.typ_composite, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION public.add(public.typ_composite, integer) OWNER TO botov_av;