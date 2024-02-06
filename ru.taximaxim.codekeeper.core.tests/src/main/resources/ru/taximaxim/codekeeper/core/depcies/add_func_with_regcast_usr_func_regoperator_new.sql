CREATE OR REPLACE FUNCTION public.f_regoperator(x integer) RETURNS text
    LANGUAGE sql
    AS $$ select 1; SELECT ('public.||==(text, text)'::regoperator)::text AS text;$$;
