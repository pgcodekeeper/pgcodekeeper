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
-- Name: testf(); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION public.testf() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;


ALTER FUNCTION public.testf() OWNER TO botov_av;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE public.t1 (
    c1 integer DEFAULT public.testf()
);


ALTER TABLE public.t1 OWNER TO botov_av;

--
-- PostgreSQL database dump complete
--

