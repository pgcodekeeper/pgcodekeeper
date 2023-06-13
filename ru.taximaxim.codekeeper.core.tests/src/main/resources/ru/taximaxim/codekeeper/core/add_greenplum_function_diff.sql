SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.test_func(integer, OUT f1 integer, OUT f2 text) RETURNS record
    LANGUAGE sql EXECUTE ON ALL SEGMENTS
    AS $_$ SELECT $1, CAST($1 AS text) || ' is text' $_$;

CREATE OR REPLACE FUNCTION public.test_func2(integer, OUT f1 integer, OUT f2 text) RETURNS record
    LANGUAGE sql
    AS $_$ SELECT $1, CAST($1 AS text) || ' is text' $_$;