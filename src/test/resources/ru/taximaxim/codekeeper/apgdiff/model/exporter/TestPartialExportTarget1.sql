--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'Some other extension';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: table1; Type: TABLE; Schema: public; Owner: ryabinin_av; Tablespace: 
--

CREATE TABLE table1 (
    col1 text,
    col2 oid,
    CONSTRAINT chk_table1 CHECK ((1 > 2))
);


ALTER TABLE public.table1 OWNER TO maindb;

COMMENT ON TABLE table1 IS 'Some other table';

--
-- Name: idx_table1; Type: INDEX; Schema: public; Owner: ryabinin_av; Tablespace: 
--

CREATE UNIQUE INDEX idx_table1 ON table1 USING btree (col1);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT CREATE ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

