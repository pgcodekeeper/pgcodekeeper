SET search_path = pg_catalog;

-- DEPCY: This FUNCTION compare is a dependency of OPERATOR: public.>(integer, integer)

CREATE OR REPLACE FUNCTION public.compare(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 <= $2 THEN $1
            ELSE $2
            END;
    $_$;

CREATE OPERATOR public.> (
	PROCEDURE = public.compare,
	LEFTARG = integer,
	RIGHTARG = integer
);