CREATE OR REPLACE FUNCTION public.f_regprocedure(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.f2(text, text)'::regprocedure)::text AS text;$$;