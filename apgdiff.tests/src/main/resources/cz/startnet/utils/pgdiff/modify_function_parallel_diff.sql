SET search_path = pg_catalog;

DROP FUNCTION public.add_unsafe(integer, integer);

CREATE OR REPLACE FUNCTION public.add_safe_second(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT PARALLEL SAFE
    AS $_$select $1 + $2;$_$;

CREATE OR REPLACE FUNCTION public.add_restricted(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $1 + $2;$_$;

CREATE OR REPLACE FUNCTION public.add_safe(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT PARALLEL RESTRICTED
    AS $_$select $1 + $2;$_$;
