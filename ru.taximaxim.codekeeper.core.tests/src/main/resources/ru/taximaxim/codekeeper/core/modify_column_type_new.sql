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
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);


ALTER TABLE public.testtable OWNER TO fordfrog;

--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

--change 3 last column types
CREATE TABLE public.t_prod (
	id bigint,
	price integer,
	total_price numeric(30,8),
	midle_price numeric(30,7),
	new_col numeric(30,7)
);

--change 2 near column types and default option
CREATE TABLE public.t_lod3 (
	id integer,
	field1 bigint,
	field2 integer,
	field3 bigint DEFAULT '9'::integer NOT NULL,
	field4 double precision
);

--change 2 last column types where exist def option
CREATE TABLE public.t_lod3_1 (
	id integer,
	field1 integer,
	field2 bigint,
	field3 integer DEFAULT 7 NOT NULL,
	field4 integer,
	field5 integer
);

--change first and last 2 columns types. To be in separate alter table
CREATE TABLE public.t_prod_1 (
	id integer,
	price integer,
	total_price numeric(30,6),
	midle_price numeric(30,8)
);

--change 1 first column types in table with changed deps
CREATE TABLE public.t_lot_prod_3 (
	id bigint,
	price integer,
	total_price numeric(30,7),
	midle_price numeric(30,7)
);

CREATE INDEX i7_1 ON public.t_lot_prod_3 USING btree (text COLLATE public.test_collation7);

--changed CONSTRAINT
ALTER TABLE public.t_lot_prod_3
	ADD CONSTRAINT id_1 CHECK ((id > 4));

--change one column and add DEFAULT option
CREATE TABLE public.t_lod4 (
	field1 bigint,
	field3 bigint DEFAULT '9'::integer NOT NULL,
	field4 numeric(20,4)
);

ALTER TABLE public.t_lod4 OWNER TO khazieva_gr;

--change 2 columns type & compression option
CREATE TABLE public.t33 (
	c0 bigint,
	c1 bigint COMPRESSION ghh,
	c2 integer
);

-- change identitiy and 2 near column types
CREATE TABLE public.testIdentity (
    id integer NOT NULL,
    c1 integer NOT NULL,
    c11 integer NOT NULL,
    c2 bigint NOT NULL,
    c3 bigint
);

ALTER TABLE public.testIdentity ALTER COLUMN c2 ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.testIdentity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
);

-- storage change, type
CREATE TABLE public.testStorage (
    c0 text,
    c1 integer STORAGE EXTERNAL,
    c11 text NOT NULL,
    c2 text NOT NULL,
    c3 bigint
);

-- comment change, types
CREATE TABLE public.comment_test (
    id bigint NOT NULL,
    text character varying(21) NOT NULL,
    new_col character varying(20) NOT NULL
);

COMMENT ON COLUMN public.comment_test.id IS 'new comment';

-- option & type of column change, 2 near types change
CREATE TABLE public.test_options (
    id integer NOT NULL,
    field1 character(60),
    field2 character(60),
    field3 character(60),
    field4 character(64),
    field5 character(64)
);
ALTER TABLE ONLY public.test_options ALTER COLUMN field1 SET (n_distinct=4, n_distinct_inherited=-0.75);

-- STATISTICS & type of column change
CREATE TABLE public.test_statistics (
    field1 bigint,
    field2 bigint,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

ALTER TABLE ONLY public.test_statistics ALTER COLUMN field2 SET STATISTICS 40;

-- SEQUENCE & type of column change
CREATE TABLE public.testSeq (
    id bigint NOT NULL,
    field1 character(60),
    field2 character(64)
);

ALTER TABLE public.testSeq ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME custom_named_seq
    START WITH 2
    INCREMENT BY 2
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

--change 2 column types where one was NOT NULL
CREATE TABLE public.test_null (
	id integer,
	field1 integer,
	field2 bigint,
	field3 double precision,
	field4 numeric(30,6),
	field5 numeric(30,6)
);

--change 2 near column types where collation change
CREATE TABLE public.testCollation (
	id bigint COLLATE "en_US",
	field1 bigint,
	field2 bigint
);

--
-- PostgreSQL database dump complete
--

