--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: testtable_ids; Type: SEQUENCE; Schema: public; Owner: shamsutdinov_lr
--

CREATE SEQUENCE testtable_ids
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE testtable_ids OWNER TO shamsutdinov_lr;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: testtable; Type: TABLE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TABLE testtable (
    id integer DEFAULT nextval('testtable_ids'::regclass) NOT NULL,
    field1 character(64),
    field2 character(64),
    field3 character(64),
    field4 character(64),
    field5 character(64)
);
ALTER TABLE ONLY testtable ALTER COLUMN field1 SET (n_distinct=0.5, n_distinct_inherited=-0.75);
ALTER TABLE ONLY testtable ALTER COLUMN field2 SET (n_distinct=-0.5, n_distinct_inherited=5.0);
ALTER TABLE ONLY testtable ALTER COLUMN field5 SET (n_distinct=-1.0);


ALTER TABLE testtable OWNER TO shamsutdinov_lr;

--
-- Name: testtable_pkey; Type: CONSTRAINT; Schema: public; Owner: shamsutdinov_lr
--

ALTER TABLE ONLY testtable
    ADD CONSTRAINT testtable_pkey PRIMARY KEY (id);


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
