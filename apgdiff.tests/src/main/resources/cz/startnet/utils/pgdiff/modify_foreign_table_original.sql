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

CREATE EXTENSION IF NOT EXISTS postgres_fdw WITH SCHEMA public;

--
-- Name: EXTENSION postgres_fdw; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION postgres_fdw IS 'foreign-data wrapper for remote PostgreSQL servers';

--
-- Name: film_server; Type: SERVER; Schema: -; Owner: galiev_mr
--

CREATE SERVER film_server FOREIGN DATA WRAPPER postgres_fdw;


ALTER SERVER film_server OWNER TO galiev_mr;

--
-- Name: new_server; Type: SERVER; Schema: -; Owner: galiev_mr
--

CREATE SERVER new_server FOREIGN DATA WRAPPER postgres_fdw;


ALTER SERVER new_server OWNER TO galiev_mr;

SET default_tablespace = '';

--
-- Name: films; Type: FOREIGN TABLE; Schema: public; Owner: galiev_mr
--

CREATE FOREIGN TABLE films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10),
    len interval hour to minute
)
SERVER film_server
OPTIONS (
    schema_name 'public',
    table_name 'films',
    updatable 'true',
    use_remote_estimate 'true'
);
ALTER TABLE ONLY films ALTER COLUMN code SET STORAGE PLAIN;
ALTER TABLE ONLY films ALTER COLUMN code SET (n_distinct_inherited=1, n_distinct=-0.7);
ALTER FOREIGN TABLE films ALTER COLUMN code OPTIONS (
    column_name 'number'
);
ALTER FOREIGN TABLE films ALTER COLUMN title OPTIONS (
    column_name 'name'
);


ALTER FOREIGN TABLE films OWNER TO galiev_mr;

SET default_with_oids = false;

--
-- Name: my_films; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE my_films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10),
    len interval hour to minute
);


ALTER TABLE my_films OWNER TO galiev_mr;

--
-- Name: new_films; Type: FOREIGN TABLE; Schema: public; Owner: galiev_mr
--

CREATE FOREIGN TABLE new_films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10),
    len interval hour to minute
)
SERVER new_server;


ALTER FOREIGN TABLE new_films OWNER TO galiev_mr;

--
-- Name: old_films; Type: FOREIGN TABLE; Schema: public; Owner: galiev_mr
--

CREATE FOREIGN TABLE old_films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10),
    len interval hour to minute
)
SERVER film_server;


ALTER FOREIGN TABLE old_films OWNER TO galiev_mr;

--
-- PostgreSQL database dump complete
--
