CREATE TRANSFORM FOR int LANGUAGE SQL (
    FROM SQL WITH FUNCTION prsd_lextype(internal),
    TO SQL WITH FUNCTION int4recv(internal));

CREATE FUNCTION public.tr_func() RETURNS integer
    LANGUAGE sql TRANSFORM FOR TYPE integer
    AS $$ select 1; $$;

CREATE OR REPLACE FUNCTION public.w_func(val anyelement, n integer = 1) RETURNS anyelement
    LANGUAGE internal WINDOW IMMUTABLE STRICT COST 1
    AS 'window_nth_value';