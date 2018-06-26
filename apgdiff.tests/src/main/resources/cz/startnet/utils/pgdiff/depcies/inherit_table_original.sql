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
-- Name: seq1; Type: SEQUENCE; Schema: public; Owner: botov_av
--

CREATE SEQUENCE public.seq1
    START WITH 1
    INCREMENT BY 2
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq1 OWNER TO botov_av;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE public.t1 (
    c1 integer DEFAULT nextval('public.seq1'::regclass),
    c2 integer
);


ALTER TABLE public.t1 OWNER TO botov_av;

--
-- Name: t2; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE public.t2 (
    c3 integer
)
INHERITS (public.t1);


ALTER TABLE public.t2 OWNER TO botov_av;

--
-- Name: c1; Type: DEFAULT; Schema: public; Owner: botov_av
--

ALTER TABLE ONLY public.t2 ALTER COLUMN c1 SET DEFAULT nextval('public.seq1'::regclass);


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

