CREATE OR REPLACE FUNCTION public.f2(a anyarray) RETURNS SETOF anyarray
    LANGUAGE plpgsql IMMUTABLE
    AS $_$
DECLARE
    s $1%TYPE;
BEGIN
    perform public.f1(s, a);
END;
$_$;