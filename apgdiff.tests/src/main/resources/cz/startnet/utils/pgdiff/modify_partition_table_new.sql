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


--
-- Name: postgres_fdw; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS postgres_fdw WITH SCHEMA public;


--
-- Name: EXTENSION postgres_fdw; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION postgres_fdw IS 'foreign-data wrapper for remote PostgreSQL servers';


SET search_path = public, pg_catalog;

--
-- Name: comp; Type: TYPE; Schema: public; Owner: galiev_mr
--

CREATE TYPE comp AS (
    f1 integer,
    f2 text,
    f3 bigint
);


ALTER TYPE comp OWNER TO galiev_mr;

--
-- Name: myserver; Type: SERVER; Schema: -; Owner: galiev_mr
--

CREATE SERVER myserver FOREIGN DATA WRAPPER postgres_fdw OPTIONS (
    dbname 'foodb',
    host 'localhost',
    port '5432'
);


ALTER SERVER myserver OWNER TO galiev_mr;

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

CREATE TABLE cities_ab PARTITION OF cities (
    CONSTRAINT constr_check CHECK ((c1 > 10))
)
FOR VALUES IN ('a', 'b');


ALTER TABLE cities_ab OWNER TO galiev_mr;

--
-- Name: cities_cd; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE cities_cd PARTITION OF cities (
    CONSTRAINT constr_check CHECK ((c1 > 5))
)
FOR VALUES IN ('c', 'd')
PARTITION BY RANGE (c3);


ALTER TABLE cities_cd OWNER TO galiev_mr;

--
-- Name: cities_cd_10_to_100; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE cities_cd_10_to_100 PARTITION OF cities_cd
FOR VALUES FROM ('1') TO ('10');


ALTER TABLE cities_cd_10_to_100 OWNER TO galiev_mr;

--
-- Name: cities_fg; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE cities_fg PARTITION OF cities
FOR VALUES IN ('e', 'g');


ALTER TABLE cities_fg OWNER TO galiev_mr;

--
-- Name: cities_mz; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE cities_mz PARTITION OF cities
FOR VALUES IN ('m', 'z')
PARTITION BY RANGE (c3);


ALTER TABLE cities_mz OWNER TO galiev_mr;

--
-- Name: f_cities_e; Type: FOREIGN TABLE; Schema: public; Owner: galiev_mr
--

CREATE FOREIGN TABLE f_cities_e PARTITION OF cities
FOR VALUES IN ('h', 'i')
SERVER myserver;


ALTER FOREIGN TABLE f_cities_e OWNER TO galiev_mr;

--
-- Name: ftable; Type: FOREIGN TABLE; Schema: public; Owner: galiev_mr
--

CREATE FOREIGN TABLE ftable (
    code integer NOT NULL
)
SERVER myserver;
ALTER TABLE ONLY ftable ALTER COLUMN code SET (n_distinct_inherited=1, n_distinct=-0.7);


ALTER FOREIGN TABLE ftable OWNER TO galiev_mr;

--
-- Name: tab_of_type; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE tab_of_type OF public.comp (
    f1 NOT NULL,
    f2 DEFAULT 'text'::text,
    f3 NOT NULL,
    CONSTRAINT tab_of_type_f3_check CHECK ((f3 > 1))
);


ALTER TABLE tab_of_type OWNER TO galiev_mr;

--
-- PostgreSQL database dump complete
--

