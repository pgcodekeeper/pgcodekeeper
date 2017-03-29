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


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE t1 (
    c1 integer,
    c2 text
);


ALTER TABLE public.t1 OWNER TO botov_av;

--
-- Name: t2; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE t2 (
    c1 integer,
    c2 text
);


ALTER TABLE public.t2 OWNER TO botov_av;

CREATE VIEW v1 AS
 SELECT t1.c1
   FROM t1;
   
--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- Name: t1.c1; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL(c1) ON TABLE t1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE t1 FROM botov_av;
GRANT ALL(c1, c2) ON TABLE t1 TO maindb;
GRANT SELECT, INSERT(c1,c2),REFERENCES(c1),UPDATE(c1) ON TABLE t1,t2 TO levsha_aa;

--
-- Name: v1.c1; Type: ACL; Schema: public; Owner: levsha_aa
--

REVOKE ALL(c1) ON TABLE v1 FROM PUBLIC;
REVOKE ALL(c1) ON TABLE v1 FROM levsha_aa;
GRANT UPDATE(c1) ON TABLE v1 TO maindb;
--
-- PostgreSQL database dump complete
--

