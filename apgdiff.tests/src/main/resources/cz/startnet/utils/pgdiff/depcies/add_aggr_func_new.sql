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

--------------------------------------------------------------------------------
-- AGGREGATE public.mode1(boolean)
--------------------------------------------------------------------------------

--
-- Name: mode_bool_state1(integer[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state1(integer[], boolean) RETURNS integer[]
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


ALTER FUNCTION public.mode_bool_state1(integer[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_state1(bigint[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_state1(bigint[], boolean) RETURNS bigint[]
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


ALTER FUNCTION public.mode_m_state1(bigint[], boolean) OWNER TO shamsutdinov_lr;


--
-- Name: mode_m_inv1(bigint[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_inv1(bigint[], boolean) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT $1
$_$;


ALTER FUNCTION public.mode_m_inv1(bigint[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final1(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final1(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final1(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_combine1(integer[], integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_combine1(integer[], integer[]) RETURNS integer[]
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


ALTER FUNCTION public.mode_combine1(integer[], integer[]) OWNER TO shamsutdinov_lr;


--
-- Name: mode_m_final1(bigint[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_final1(bigint[]) RETURNS boolean
    LANGUAGE sql
    AS $$
SELECT 1>2
$$;


ALTER FUNCTION public.mode_m_final1(bigint[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode1(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode1(boolean) (
    SFUNC = public.mode_bool_state1,
    STYPE = integer[],
    INITCOND = '{0,0}',
    COMBINEFUNC = public.mode_combine1,
    FINALFUNC = public.mode_bool_final1,
    MSFUNC = public.mode_m_state1,
    MSTYPE = bigint[],
    MINVFUNC = public.mode_m_inv1,
    MFINALFUNC = public.mode_m_final1
);


ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------
-- AGGREGATE public.mode3(*)
--------------------------------------------------------------------------------

--
-- Name: mode_bool_state3(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state3(integer[]) RETURNS integer[]
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


ALTER FUNCTION public.mode_bool_state3(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_state3(bigint[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_state3(bigint[]) RETURNS bigint[]
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


ALTER FUNCTION public.mode_m_state3(bigint[]) OWNER TO shamsutdinov_lr;


--
-- Name: mode_m_inv3(bigint[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_inv3(bigint[]) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT $1
$_$;


ALTER FUNCTION public.mode_m_inv3(bigint[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final3(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final3(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final3(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_combine3(integer[], integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_combine3(integer[], integer[]) RETURNS integer[]
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


ALTER FUNCTION public.mode_combine3(integer[], integer[]) OWNER TO shamsutdinov_lr;


--
-- Name: mode_m_final3(bigint[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_final3(bigint[]) RETURNS boolean
    LANGUAGE sql
    AS $$
SELECT 1>2
$$;


ALTER FUNCTION public.mode_m_final3(bigint[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode3(*); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode3(*) (
    SFUNC = public.mode_bool_state3,
    STYPE = integer[],
    INITCOND = '{0,0}',
    COMBINEFUNC = public.mode_combine3,
    FINALFUNC = public.mode_bool_final3,
    MSFUNC = public.mode_m_state3,
    MSTYPE = bigint[],
    MINVFUNC = public.mode_m_inv3,
    MFINALFUNC = public.mode_m_final3
);


ALTER AGGREGATE public.mode3(*) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------
-- AGGREGATE public.mode4(ORDER BY boolean)
--------------------------------------------------------------------------------

--
-- Name: mode_bool_state4(integer[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state4(integer[], boolean) RETURNS integer[]
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


ALTER FUNCTION public.mode_bool_state4(integer[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_state4(bigint[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_state4(bigint[], boolean) RETURNS bigint[]
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


ALTER FUNCTION public.mode_m_state4(bigint[], boolean) OWNER TO shamsutdinov_lr;


--
-- Name: mode_m_inv4(bigint[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_inv4(bigint[], boolean) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT $1
$_$;


ALTER FUNCTION public.mode_m_inv4(bigint[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final4(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final4(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final4(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_combine4(integer[], integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_combine4(integer[], integer[]) RETURNS integer[]
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


ALTER FUNCTION public.mode_combine4(integer[], integer[]) OWNER TO shamsutdinov_lr;


--
-- Name: mode_m_final4(bigint[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_final4(bigint[]) RETURNS boolean
    LANGUAGE sql
    AS $$
SELECT 1>2
$$;


ALTER FUNCTION public.mode_m_final4(bigint[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode4(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode4(ORDER BY boolean) (
    SFUNC = public.mode_bool_state4,
    STYPE = integer[],
    INITCOND = '{0,0}',
    COMBINEFUNC = public.mode_combine4,
    FINALFUNC = public.mode_bool_final4,
    MSFUNC = public.mode_m_state4,
    MSTYPE = bigint[],
    MINVFUNC = public.mode_m_inv4,
    MFINALFUNC = public.mode_m_final4
);


ALTER AGGREGATE public.mode4(ORDER BY boolean) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------
-- AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text)
--------------------------------------------------------------------------------

--
-- Name: mode_bool_state11(integer[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_bool_state11(integer[], boolean, text) RETURNS integer[]
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


ALTER FUNCTION public.mode_bool_state11(integer[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final11(integer[], boolean, integer, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_bool_final11(integer[], boolean, integer, text) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final11(integer[], boolean, integer, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_combine11(integer[], integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_combine11(integer[], integer[]) RETURNS integer[]
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


ALTER FUNCTION public.mode_combine11(integer[], integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_state11(bigint[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_state11(bigint[], boolean, text) RETURNS bigint[]
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


ALTER FUNCTION public.mode_m_state11(bigint[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_inv11(bigint[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_inv11(bigint[], boolean, text) RETURNS bigint[]
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


ALTER FUNCTION public.mode_m_inv11(bigint[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_m_final11(bigint[], boolean, integer, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_m_final11(bigint[], boolean, integer, text) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_m_final11(bigint[], boolean, integer, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode11_params(boolean, integer, text, boolean, text); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) (
    SFUNC = public.mode_bool_state11,
    STYPE = integer[],
    INITCOND = '{0,0}',
    COMBINEFUNC = public.mode_combine11,
    FINALFUNC = public.mode_bool_final11,
    MSFUNC = public.mode_m_state11,
    MSTYPE = bigint[],
    MINVFUNC = public.mode_m_inv11,
    MFINALFUNC = public.mode_m_final11
);


ALTER AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;
