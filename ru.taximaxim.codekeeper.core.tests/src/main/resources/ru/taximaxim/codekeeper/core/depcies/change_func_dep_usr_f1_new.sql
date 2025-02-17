CREATE OR REPLACE FUNCTION public.f1() RETURNS integer
    LANGUAGE sql
    AS $$ select 1::public.the_my_type;$$;