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
-- Name: republic; Type: SCHEMA; Schema: -; Owner: botov_av
--

CREATE SCHEMA republic;


ALTER SCHEMA republic OWNER TO botov_av;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t_test2; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE t_test2 (
    c_name_t_test2 text,
    c_id_t_test2 text
);


ALTER TABLE public.t_test2 OWNER TO botov_av;

SET search_path = public, pg_catalog;

--
-- Name: unique_referenced; Type: CONSTRAINT; Schema: public; Owner: botov_av; Tablespace: 
--

ALTER TABLE ONLY t_test2
    ADD CONSTRAINT unique_referenced UNIQUE (c_name_t_test2);

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

