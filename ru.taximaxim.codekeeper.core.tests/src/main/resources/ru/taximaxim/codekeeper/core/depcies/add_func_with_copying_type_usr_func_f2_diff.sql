SET search_path = pg_catalog;

-- DEPCY: This FUNCTION f1 is a dependency of FUNCTION: public.f2(anyarray)

CREATE OR REPLACE FUNCTION public.f1(s anyarray, a anyarray) RETURNS SETOF anyarray
    LANGUAGE plpgsql IMMUTABLE
    AS $$
BEGIN
    RETURN;
END;
$$;

CREATE OR REPLACE FUNCTION public.f2(a anyarray) RETURNS SETOF anyarray
    LANGUAGE plpgsql IMMUTABLE
    AS $_$
DECLARE
    s $1%TYPE;
BEGIN
    perform public.f1(s, a);
END;
$_$;