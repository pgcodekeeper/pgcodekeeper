CREATE OR REPLACE FUNCTION public.f_regproc(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.f1'::regproc)::text AS text;$$;