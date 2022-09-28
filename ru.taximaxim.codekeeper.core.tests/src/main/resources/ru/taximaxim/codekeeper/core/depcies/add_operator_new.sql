CREATE OR REPLACE FUNCTION public.compare(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 <= $2 THEN $1
            ELSE $2
            END;
    $_$;

CREATE OR REPLACE FUNCTION public.compare(boolean, boolean) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $$
    SELECT 1;
    $$;

CREATE OPERATOR public.> (
    PROCEDURE = public.compare,
    LEFTARG = integer,
    RIGHTARG = integer
);