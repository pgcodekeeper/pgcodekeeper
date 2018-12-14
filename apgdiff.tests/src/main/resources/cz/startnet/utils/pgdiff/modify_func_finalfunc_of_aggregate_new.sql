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
-- Name: mode_bool_state(integer[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_bool_state(integer[], boolean, text) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_bool_state(integer[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final(integer[], boolean, integer, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_bool_final(integer[], boolean, integer, text) RETURNS bytea
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final(integer[], boolean, integer, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_combine(integer[], integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_combine(integer[], integer[]) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_combine(integer[], integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_state(bigint[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_state(bigint[], boolean, text) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_m_state(bigint[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_inv(bigint[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_inv(bigint[], boolean, text) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_m_inv(bigint[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_final(bigint[], boolean, integer, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_final(bigint[], boolean, integer, text) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_m_final(bigint[], boolean, integer, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode11_params(boolean, integer, text, boolean, text); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final,
    COMBINEFUNC = public.mode_combine,
    MSFUNC = public.mode_m_state,
    MINVFUNC = public.mode_m_inv,
    MSTYPE = bigint[],
    MFINALFUNC = public.mode_m_final
);


ALTER AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;