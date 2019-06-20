SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.tr_func() RETURNS integer
    LANGUAGE sql TRANSFORM FOR TYPE integer
    AS $$ select 1; $$;

CREATE OR REPLACE FUNCTION public.w_func(val anyelement, n integer = 1) RETURNS anyelement
    LANGUAGE internal WINDOW IMMUTABLE STRICT
    AS 'window_nth_value';