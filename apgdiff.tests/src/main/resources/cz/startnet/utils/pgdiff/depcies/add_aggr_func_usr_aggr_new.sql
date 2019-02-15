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
