CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE sql
    AS $$ select 1;$$;