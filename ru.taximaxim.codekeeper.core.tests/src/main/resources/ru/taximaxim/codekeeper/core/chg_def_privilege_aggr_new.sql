--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = pg_catalog;

--
-- Name: mode_bool_state(integer[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_bool_state(integer[], boolean) RETURNS integer[]
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

--
-- Name: mode_bool_final(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.mode_bool_final(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_bool_final(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode1; Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode1(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    FINALFUNC = public.mode_bool_final,
    INITCOND = '{10}'
);

ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: FUNCTION mode1(boolean); Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

REVOKE ALL ON FUNCTION public.mode1(boolean) FROM PUBLIC;

--
-- Name: mode2; Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode2(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    FINALFUNC = public.mode_bool_final,
    INITCOND = '{10}'
);

ALTER AGGREGATE public.mode2(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode3; Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode3(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    FINALFUNC = public.mode_bool_final,
    INITCOND = '{10}'
);

ALTER AGGREGATE public.mode3(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

--
-- PostgreSQL database dump complete
--

