SET search_path = pg_catalog;

-- DEPCY: This FUNCTION f2 is a dependency of FUNCTION: public.f_regprocedure(integer)

CREATE OR REPLACE FUNCTION public.f2(f1 text, f2 text) RETURNS text
    LANGUAGE sql
    AS $$ select 1;$$;

CREATE OR REPLACE FUNCTION public.f_regprocedure(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.f2(text, text)'::regprocedure)::text AS text;$$;