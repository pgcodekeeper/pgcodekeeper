--
-- PostgreSQL database dump
--
SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;


SET search_path = public, pg_catalog;

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
-- PostgreSQL database dump complete
--

