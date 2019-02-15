CREATE FUNCTION public.f(p double precision) RETURNS double precision
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION public.f(p double precision) OWNER TO shamsutdinov_lr;

CREATE FUNCTION public.f(p integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION public.f(p integer) OWNER TO shamsutdinov_lr;

CREATE FUNCTION public.f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

ALTER FUNCTION public.f(s text) OWNER TO shamsutdinov_lr;

CREATE VIEW public.v1 AS
 SELECT public.f((3)::double precision) AS f;

ALTER TABLE public.v1 OWNER TO shamsutdinov_lr;

CREATE VIEW public.v2 AS
 SELECT public.f(3) AS f;

ALTER TABLE public.v2 OWNER TO shamsutdinov_lr;