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
-- Name: f(text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

--
-- Name: FUNCTION f(s text); Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

REVOKE ALL ON FUNCTION public.f(s text) FROM PUBLIC;

--
-- Name: t; Type: TYPE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TYPE public.t AS (c1 int, c2 text);

--
-- Name: TYPE public.t; Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

REVOKE ALL ON TYPE public.t FROM PUBLIC;

--
-- Name: tbl; Type: TABLE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TABLE public.tbl (
    c1 integer
);

--
-- Name: TABLE public.tbl; Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

GRANT ALL ON TABLE public.tbl TO PUBLIC;

-------------------------------------------------------------------------------

--
-- Name: f2(text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE OR REPLACE FUNCTION public.f2(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

--
-- Name: FUNCTION f2(s text); Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

GRANT ALL ON FUNCTION public.f2(s text) TO PUBLIC;

--
-- Name: t; Type: TYPE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TYPE public.t2 AS (c1 int, c2 text);

--
-- Name: TYPE public.t2; Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

GRANT ALL ON TYPE public.t2 TO PUBLIC;

--
-- Name: tbl; Type: TABLE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TABLE public.tbl2 (
    c1 integer
);

--
-- Name: TABLE public.tbl2; Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

REVOKE ALL ON TABLE public.tbl2 FROM PUBLIC;

-- default revoke

CREATE OR REPLACE FUNCTION public.f3(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

-- default grant  

CREATE OR REPLACE FUNCTION public.f4(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

REVOKE ALL ON FUNCTION public.f4(s text) FROM PUBLIC;

-------------------------------------------------------------------------------

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

