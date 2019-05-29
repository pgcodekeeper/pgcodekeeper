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

ALTER FUNCTION public.f(s text) OWNER TO shamsutdinov_lr;

--
-- Name: FUNCTION f(s text); Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

REVOKE ALL ON FUNCTION public.f(s text) FROM PUBLIC;
REVOKE ALL ON FUNCTION public.f(s text) FROM shamsutdinov_lr;

--
-- Name: t; Type: TYPE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TYPE public.t AS (c1 int, c2 text);

ALTER TYPE public.t OWNER TO shamsutdinov_lr;

--
-- Name: TYPE public.t; Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

REVOKE ALL ON TYPE public.t FROM PUBLIC;
REVOKE ALL ON TYPE public.t FROM shamsutdinov_lr;

--
-- Name: tbl; Type: TABLE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TABLE public.tbl (
    c1 integer
);

ALTER TABLE public.tbl OWNER TO shamsutdinov_lr;

--
-- Name: TABLE public.tbl; Type: ACL; Schema: public; Owner: shamsutdinov_lr
--

GRANT ALL ON TABLE public.tbl TO PUBLIC;
REVOKE ALL ON TABLE public.tbl FROM shamsutdinov_lr;

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

