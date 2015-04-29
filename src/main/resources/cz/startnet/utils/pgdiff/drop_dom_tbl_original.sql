--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = public, pg_catalog;

--
-- Name: dom2; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom2 AS integer NOT NULL DEFAULT (-100)
	CONSTRAINT dom2_check CHECK ((VALUE < 1000));


ALTER DOMAIN dom2 OWNER TO botov_av;

--
-- Name: distributors; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE distributors (
    did dom2,
    name character varying(40)
);


ALTER TABLE distributors OWNER TO botov_av;

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

