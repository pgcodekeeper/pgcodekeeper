CREATE OR REPLACE FUNCTION public.f_regoper(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.||++'::regoper)::text AS text;$$;
