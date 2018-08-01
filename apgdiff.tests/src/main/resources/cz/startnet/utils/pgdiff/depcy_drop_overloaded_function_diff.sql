SET search_path = pg_catalog;

-- DEPCY: This VIEW depends on the FUNCTION: public.f(integer)

DROP VIEW public.v2;

DROP FUNCTION public.f(p integer);

-- DEPCY: This FUNCTION is a dependency of VIEW: public.v2

CREATE OR REPLACE FUNCTION public.f(p integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION public.f(p integer) OWNER TO shamsutdinov_lr;

CREATE VIEW public.v2 AS
	SELECT f(3) AS f;

ALTER VIEW public.v2 OWNER TO shamsutdinov_lr;
