SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.functest1(a integer, b integer)
    LANGUAGE "SQL"
    AS $_$SELECT $2$_$;

ALTER FUNCTION public.functest1(a integer, b integer) OWNER TO test_2;

COMMENT ON FUNCTION public.functest1(a integer, b integer) IS 'test function 2';