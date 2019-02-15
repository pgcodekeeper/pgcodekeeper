--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';

--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: 
--

CREATE PROCEDURAL LANGUAGE plpgsql;


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


--
-- Name: mode_bool_final(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final(integer[], boolean) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final(integer[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_state(integer[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state(integer[], boolean) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE $2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_bool_state(integer[], boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode5(boolean ORDER BY boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    FINALFUNC = public.mode_bool_final,
    INITCOND = '{0,0}',
    PARALLEL = SAFE,
    HYPOTHETICAL 
);

ALTER AGGREGATE public.mode5(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

