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


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: f(double precision); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION f(p double precision) RETURNS double precision
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;


ALTER FUNCTION public.f(p double precision) OWNER TO shamsutdinov_lr;

--
-- Name: f(integer); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION f(p integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;


ALTER FUNCTION public.f(p integer) OWNER TO shamsutdinov_lr;

--
-- Name: f(text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;


ALTER FUNCTION public.f(s text) OWNER TO shamsutdinov_lr;

--
-- Name: v1; Type: VIEW; Schema: public; Owner: shamsutdinov_lr
--

CREATE VIEW v1 AS
 SELECT f((3)::double precision) AS f;


ALTER TABLE v1 OWNER TO shamsutdinov_lr;

--
-- Name: v2; Type: VIEW; Schema: public; Owner: shamsutdinov_lr
--

CREATE VIEW v2 AS
 SELECT f(3) AS f;


ALTER TABLE v2 OWNER TO shamsutdinov_lr;

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

