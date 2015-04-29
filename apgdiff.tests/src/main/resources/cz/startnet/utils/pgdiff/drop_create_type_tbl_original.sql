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
-- Name: typ_composite; Type: TYPE; Schema: public; Owner: botov_av
--

CREATE TYPE typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU.utf8"
);


ALTER TYPE typ_range OWNER TO botov_av;

--
-- Name: distributors; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE distributors (
    did typ_range,
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

