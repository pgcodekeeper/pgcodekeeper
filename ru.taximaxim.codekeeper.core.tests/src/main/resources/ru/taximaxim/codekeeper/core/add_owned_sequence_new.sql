--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
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


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: table1; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.table1 (
    col1 integer NOT NULL
);


ALTER TABLE public.table1 OWNER TO fordfrog;

--
-- Name: table1_col1_seq; Type: SEQUENCE; Schema: public; Owner: fordfrog
--

CREATE SEQUENCE public.table1_col1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.table1_col1_seq OWNER TO fordfrog;

--
-- Name: table1_col1_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: fordfrog
--

ALTER SEQUENCE public.table1_col1_seq OWNED BY public.table1.col1;


--
-- Name: table1_col1_seq; Type: SEQUENCE SET; Schema: public; Owner: fordfrog
--

SELECT pg_catalog.setval('public.table1_col1_seq', 1, false);


--
-- Name: table2; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.table2 (
    col1 integer NOT NULL
);


ALTER TABLE public.table2 OWNER TO fordfrog;

--
-- Name: table2_col1_seq; Type: SEQUENCE; Schema: public; Owner: fordfrog
--

CREATE SEQUENCE public.table2_col1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.table2_col1_seq OWNER TO fordfrog;

--
-- Name: table2_col1_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: fordfrog
--

ALTER SEQUENCE public.table2_col1_seq OWNED BY public.table2.col1;


--
-- Name: table2_col1_seq; Type: SEQUENCE SET; Schema: public; Owner: fordfrog
--

SELECT pg_catalog.setval('public.table2_col1_seq', 1, false);


--
-- Name: col1; Type: DEFAULT; Schema: public; Owner: fordfrog
--

ALTER TABLE ONLY public.table1 ALTER COLUMN col1 SET DEFAULT nextval('public.table1_col1_seq'::regclass);


--
-- Name: col1; Type: DEFAULT; Schema: public; Owner: fordfrog
--

ALTER TABLE ONLY public.table2 ALTER COLUMN col1 SET DEFAULT nextval('public.table2_col1_seq'::regclass);

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

