--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


--
-- Name: testschema1; Type: SCHEMA; Schema: -; Owner: fordfrog
--

CREATE SCHEMA testschema1;


ALTER SCHEMA testschema1 OWNER TO fordfrog;

SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: testtable1; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.testtable1 (
    id bigint NOT NULL
);


ALTER TABLE public.testtable1 OWNER TO fordfrog;

--
-- Name: testtable1_id_seq; Type: SEQUENCE; Schema: public; Owner: fordfrog
--

CREATE SEQUENCE public.testtable1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.testtable1_id_seq OWNER TO fordfrog;

--
-- Name: testtable1_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: fordfrog
--

ALTER SEQUENCE public.testtable1_id_seq OWNED BY public.testtable1.id;


--
-- Name: testtable1_id_seq; Type: SEQUENCE SET; Schema: public; Owner: fordfrog
--

SELECT pg_catalog.setval('public.testtable1_id_seq', 1, false);


--
-- Name: testtable2; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.testtable2 (
    id integer NOT NULL
);


ALTER TABLE public.testtable2 OWNER TO fordfrog;

--
-- Name: testtable2_id_seq; Type: SEQUENCE; Schema: public; Owner: fordfrog
--

CREATE SEQUENCE public.testtable2_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.testtable2_id_seq OWNER TO fordfrog;

--
-- Name: testtable2_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: fordfrog
--

ALTER SEQUENCE public.testtable2_id_seq OWNED BY public.testtable2.id;


--
-- Name: testtable2_id_seq; Type: SEQUENCE SET; Schema: public; Owner: fordfrog
--

SELECT pg_catalog.setval('public.testtable2_id_seq', 1, false);

--
-- Name: testtable1; Type: TABLE; Schema: testschema1; Owner: fordfrog; Tablespace: 
--

CREATE TABLE testschema1.testtable1 (
    id integer NOT NULL
);


ALTER TABLE testschema1.testtable1 OWNER TO fordfrog;

--
-- Name: testtable1_id_seq; Type: SEQUENCE; Schema: testschema1; Owner: fordfrog
--

CREATE SEQUENCE testschema1.testtable1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE testschema1.testtable1_id_seq OWNER TO fordfrog;

--
-- Name: testtable1_id_seq; Type: SEQUENCE OWNED BY; Schema: testschema1; Owner: fordfrog
--

ALTER SEQUENCE testschema1.testtable1_id_seq OWNED BY testschema1.testtable1.id;


--
-- Name: testtable1_id_seq; Type: SEQUENCE SET; Schema: testschema1; Owner: fordfrog
--

SELECT pg_catalog.setval('testschema1.testtable1_id_seq', 1, false);

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: fordfrog
--

ALTER TABLE public.testtable1 ALTER COLUMN id SET DEFAULT nextval('public.testtable1_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: fordfrog
--

ALTER TABLE public.testtable2 ALTER COLUMN id SET DEFAULT nextval('public.testtable2_id_seq'::regclass);



--
-- Name: id; Type: DEFAULT; Schema: testschema1; Owner: fordfrog
--

ALTER TABLE testschema1.testtable1 ALTER COLUMN id SET DEFAULT nextval('testschema1.testtable1_id_seq'::regclass);



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

