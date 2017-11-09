DROP FUNCTION add_unsafe(integer, integer);

CREATE OR REPLACE FUNCTION add_safe_second(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT PARALLEL SAFE
    AS $_$select $1 + $2;$_$;

ALTER FUNCTION add_safe_second(integer, integer) OWNER TO galiev_mr;

CREATE OR REPLACE FUNCTION add_restricted(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $1 + $2;$_$;

ALTER FUNCTION add_restricted(integer, integer) OWNER TO galiev_mr;

CREATE OR REPLACE FUNCTION add_safe(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT PARALLEL RESTRICTED
    AS $_$select $1 + $2;$_$;
