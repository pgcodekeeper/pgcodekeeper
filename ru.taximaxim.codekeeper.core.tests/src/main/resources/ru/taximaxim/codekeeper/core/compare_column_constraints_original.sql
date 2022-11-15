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


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: testtable; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.testtable (
    c1 integer PRIMARY KEY,
    c2 integer UNIQUE,
    c3 character varying(150) DEFAULT 'none'::character varying,
    c4 integer CHECK (c4 > 0)
);

ALTER TABLE public.testtable OWNER TO fordfrog;

--
-- Name: testtable2; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.testtable2 (
    c1 integer NOT NULL DEFAULT 350 UNIQUE,
    c2 integer REFERENCES public.testtable(c1),
    c3 text,
    c4 integer CONSTRAINT check_positive CHECK (c4 > 0)
);


ALTER TABLE public.testtable2 OWNER TO fordfrog;


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

-- Testing the nulls not distinct option in constraints

CREATE TABLE public.testtable3 (
    id integer UNIQUE NULLS NOT DISTINCT,
    value1 integer UNIQUE NULLS DISTINCT,
    value2 text,
    value3 integer UNIQUE,
    value4 text,
    CONSTRAINT uq_nulls UNIQUE NULLS NOT DISTINCT (value2)
);

ALTER TABLE public.testtable3 
    ADD CONSTRAINT uq_nulls1 UNIQUE NULLS NOT DISTINCT (value4);

--
-- PostgreSQL database dump complete
--

