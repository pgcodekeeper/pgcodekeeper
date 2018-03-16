--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

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

--
-- Name: comp; Type: TYPE; Schema: public; Owner: galiev_mr
--

CREATE TYPE comp AS (
    c1 integer,
    c2 text,
    c3 bigint
);


ALTER TYPE comp OWNER TO galiev_mr;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cities; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));


ALTER TABLE cities OWNER TO galiev_mr;

--
-- Name: cities_ab; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE cities_ab OF public.comp (
    CONSTRAINT constr_check CHECK ((c1 > 10))
);


ALTER TABLE cities_ab OWNER TO galiev_mr;

--
-- PostgreSQL database dump complete
--

