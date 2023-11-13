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
    c1 integer NOT NULL,
    c2 integer,
    c3 character varying(150) DEFAULT 'none'::character varying,
    c4 integer
);

ALTER TABLE public.testtable OWNER TO fordfrog;

--------------------------------------------------------------------------------

ALTER TABLE public.testtable
    ADD CONSTRAINT testtable_pkey PRIMARY KEY (c1);

--------------------------------------------------------------------------------

ALTER TABLE public.testtable
    ADD CONSTRAINT testtable_c2_key UNIQUE (c2);

--------------------------------------------------------------------------------

ALTER TABLE public.testtable
    ADD CONSTRAINT testtable_c4_check CHECK ((c4 > 0));

--
-- Name: testtable2; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE public.testtable2 (
    c1 integer DEFAULT 350 NOT NULL,
    c2 integer,
    c3 text,
    c4 integer
);

ALTER TABLE public.testtable2 OWNER TO fordfrog;

ALTER TABLE public.testtable2
    ADD CONSTRAINT testtable2_c2_fkey FOREIGN KEY (c2) REFERENCES public.testtable(c1);

ALTER TABLE public.testtable2
    ADD CONSTRAINT testtable2_c1_key UNIQUE (c1);

ALTER TABLE public.testtable2
    ADD CONSTRAINT check_positive CHECK ((c4 > 0)) NO INHERIT;

--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

-- Testing the nulls not distinct option in constraints

CREATE TABLE public.testtable3 (
    id integer UNIQUE NULLS DISTINCT,
    value1 integer UNIQUE NULLS NOT DISTINCT,
    value2 text,
    value3 integer UNIQUE NULLS DISTINCT,
    value4 text,
    CONSTRAINT uq_nulls UNIQUE (value2)
);

ALTER TABLE public.testtable3 
    ADD CONSTRAINT uq_nulls1 UNIQUE NULLS DISTINCT (value4) WITH (fillfactor=70);

--
-- PostgreSQL database dump complete
--

