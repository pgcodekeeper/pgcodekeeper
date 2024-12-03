SET search_path = pg_catalog;

-- DEPCY: This FUNCTION nonull_append_strings is a dependency of FUNCTION: public.f_regoper(integer)

CREATE OR REPLACE FUNCTION public.nonull_append_strings(text) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $$ select 1; $$;

-- DEPCY: This OPERATOR ||++ is a dependency of FUNCTION: public.f_regoper(integer)

CREATE OPERATOR public.||++ (
	PROCEDURE = public.nonull_append_strings,
	RIGHTARG = text
);

CREATE OR REPLACE FUNCTION public.f_regoper(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.||++'::regoper)::text AS text;$$;