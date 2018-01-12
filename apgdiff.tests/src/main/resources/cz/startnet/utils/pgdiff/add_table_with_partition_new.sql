--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: comp; Type: TYPE; Schema: public; Owner: fordfrog
--

CREATE TYPE comp AS (
    f1 integer,
    f2 text,
    f3 bigint
);


ALTER TYPE comp OWNER TO fordfrog;

--
-- Name: testtable; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);


ALTER TABLE public.testtable OWNER TO fordfrog;

--
-- Name: simple_table; Type: TABLE; Schema: public; Owner: fordfrog
--

CREATE TABLE simple_table (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));


ALTER TABLE simple_table OWNER TO fordfrog;

--
-- Name: table_of_type; Type: TABLE; Schema: public; Owner: fordfrog
--

CREATE TABLE table_of_type OF public.comp (
    f1 NOT NULL,
    f2 DEFAULT 'text'::text,
    CONSTRAINT tab_of_type_f3_check CHECK ((f3 > 0))
)
PARTITION BY LIST ("left"(lower(f2), 1));


ALTER TABLE table_of_type OWNER TO fordfrog;


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

