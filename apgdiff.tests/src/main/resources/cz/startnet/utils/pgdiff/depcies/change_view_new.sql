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

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


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
-- Name: t2; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE t2 (
    c1 integer,
    c2 text,
    c4 text,
    c5 date,
    c6 text
);


ALTER TABLE t2 OWNER TO galiev_mr;

--
-- Name: t3; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE t3 (
    c1 integer,
    c2 text,
    c3 text
);


ALTER TABLE t3 OWNER TO galiev_mr;

--
-- Name: v1; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v1 AS
 SELECT t1.c1,
    t1.c2,
    t1.c3,
    t1.c4
   FROM t1;


ALTER TABLE v1 OWNER TO galiev_mr;

--
-- Name: v2; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v2 AS
 SELECT t2.c1,
    t2.c2,
    t2.c4
   FROM t2;


ALTER TABLE v2 OWNER TO galiev_mr;

--
-- Name: v3; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v3 AS
 SELECT t1.c1,
    t2.c2,
    t1.c6
   FROM t1,
    t2;


ALTER TABLE v3 OWNER TO galiev_mr;

--
-- Name: v4; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v4 AS
 SELECT v1.c1,
    v3.c2,
    t1.c4
   FROM v1,
    v3,
    t1;


ALTER TABLE v4 OWNER TO galiev_mr;

--
-- Name: v5; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v5 AS
 SELECT v2.c1,
    v3.c2,
    v4.c4
   FROM v2,
    v3,
    v4;


ALTER TABLE v5 OWNER TO galiev_mr;

--
-- Name: v6; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v6 AS
 SELECT v2.c1,
    v2.c2,
    t1.c6
   FROM v2,
    t1;


ALTER TABLE v6 OWNER TO galiev_mr;

--
-- Name: v7; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW v7 AS
 SELECT v2.c1,
    v6.c2
   FROM v2,
    v6;


ALTER TABLE v7 OWNER TO galiev_mr;

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

