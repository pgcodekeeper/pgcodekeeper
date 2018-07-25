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
-- Name: s; Type: SCHEMA; Schema: -; Owner: levsha_aa
--

CREATE SCHEMA s;


ALTER SCHEMA s OWNER TO levsha_aa;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1; Type: TABLE; Schema: public; Owner: levsha_aa; Tablespace: 
--

CREATE TABLE public.t1 (
    id integer
);


ALTER TABLE public.t1 OWNER TO levsha_aa;

--
-- Name: v2; Type: VIEW; Schema: public; Owner: levsha_aa
--

CREATE VIEW public.v2 AS
 SELECT t1.id
   FROM public.t1;


ALTER TABLE public.v2 OWNER TO levsha_aa;


--
-- Name: v1; Type: VIEW; Schema: s; Owner: levsha_aa
--

CREATE VIEW s.v1 AS
 SELECT t1.id
   FROM public.t1;


ALTER TABLE s.v1 OWNER TO levsha_aa;

--
-- Name: v3; Type: VIEW; Schema: s; Owner: levsha_aa
--

CREATE VIEW s.v3 AS
 SELECT v2.id,
    'asd' AS asd
   FROM public.v2;


ALTER TABLE s.v3 OWNER TO levsha_aa;

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
