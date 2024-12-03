SET search_path = pg_catalog;

-- DEPCY: This FUNCTION f1 is a dependency of FUNCTION: public.f_regproc(integer)

CREATE OR REPLACE FUNCTION public.f1(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1;$$;

CREATE OR REPLACE FUNCTION public.f_regproc(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.f1'::regproc)::text AS text;$$;