--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

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
-- Name: t1; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE t1 (
    c1 integer,
    c2 text,
    c3 text,
    c4 integer,
    c5 integer,
    c6 text
);


ALTER TABLE t1 OWNER TO galiev_mr;

--
-- Name: v8; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v8 AS
 SELECT v5.c1,
    v7.c2,
    t3.c3
   FROM v5,
    v7,
    t3;


ALTER TABLE v8 OWNER TO galiev_mr;

--
-- PostgreSQL database dump complete
--

