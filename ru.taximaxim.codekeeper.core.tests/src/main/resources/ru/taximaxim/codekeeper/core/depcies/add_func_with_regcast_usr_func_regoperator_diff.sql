SET search_path = pg_catalog;

-- DEPCY: This FUNCTION nonull_append_strings is a dependency of FUNCTION: public.f_regoperator(integer)

CREATE OR REPLACE FUNCTION public.nonull_append_strings(text, text) RETURNS boolean
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 IS NULL THEN FALSE
            WHEN $2 IS NULL THEN FALSE
            ELSE TRUE
            END;
    $_$;

-- DEPCY: This OPERATOR ||== is a dependency of FUNCTION: public.f_regoperator(integer)

CREATE OPERATOR public.||== (
	PROCEDURE = public.nonull_append_strings,
	LEFTARG = text,
	RIGHTARG = text
);

CREATE OR REPLACE FUNCTION public.f_regoperator(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.||==(text, text)'::regoperator)::text AS text;$$;