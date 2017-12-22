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
-- Name: testtable; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE testtable (
    c1 integer NOT NULL,
    c2 integer,
    c3 character varying(150) DEFAULT 'none'::character varying,
    c4 integer
);

ALTER TABLE testtable OWNER TO fordfrog;

--------------------------------------------------------------------------------

ALTER TABLE testtable
    ADD CONSTRAINT testtable_pkey PRIMARY KEY (c1);

--------------------------------------------------------------------------------

ALTER TABLE testtable
    ADD CONSTRAINT testtable_c2_key UNIQUE (c2);

--------------------------------------------------------------------------------

ALTER TABLE testtable
    ADD CONSTRAINT testtable_c4_check CHECK ((c4 > 0));

--
-- Name: testtable2; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE testtable2 (
    c1 integer DEFAULT 350 NOT NULL,
    c2 integer,
    c3 text,
    c4 integer
);

ALTER TABLE testtable2 OWNER TO fordfrog;

ALTER TABLE testtable2
    ADD CONSTRAINT testtable2_c2_fkey FOREIGN KEY (c2) REFERENCES testtable(c1);

ALTER TABLE testtable2
    ADD CONSTRAINT testtable2_c1_key UNIQUE (c1);

ALTER TABLE testtable2
    ADD CONSTRAINT check_positive CHECK ((c4 > 0));

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

