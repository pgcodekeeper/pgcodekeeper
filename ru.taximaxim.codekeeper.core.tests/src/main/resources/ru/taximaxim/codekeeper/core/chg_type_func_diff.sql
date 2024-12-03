SET search_path = pg_catalog;

-- DEPCY: This FUNCTION add depends on the TYPE: public.typ_composite

DROP FUNCTION public.add(public.typ_composite, integer);

ALTER TYPE public.typ_composite
	ALTER ATTRIBUTE key TYPE character varying(80) COLLATE pg_catalog."ru_RU",
	ALTER ATTRIBUTE val TYPE text COLLATE pg_catalog."en_GB.utf8";

CREATE OR REPLACE FUNCTION public.add(public.typ_composite, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;

ALTER FUNCTION public.add(public.typ_composite, integer) OWNER TO botov_av;