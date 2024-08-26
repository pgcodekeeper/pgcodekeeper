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
    field1 smallint,
    field2 integer,
    field3 character varying(100) DEFAULT 'none'::character varying,
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

--change 3 last column types. Must be in one Alter table scropt
CREATE TABLE public.t_prod (
	id bigint,
	price integer,
	total_price numeric(30,6),
	midle_price numeric(30,6),
	new_col numeric(30,6)
);

--change 2 near column types and default option
CREATE TABLE public.t_lod3 (
	id integer,
	field1 integer,
	field2 bigint,
	field3 integer DEFAULT 7 NOT NULL,
	field4 double precision
);

--change 2 last column types where exist def option
CREATE TABLE public.t_lod3_1 (
	id integer,
	field1 integer,
	field2 bigint,
	field3 integer DEFAULT 7 NOT NULL,
	field4 double precision,
	field5 numeric(30,6)
);

--change first and last 2 column types. To be in separate alter table
CREATE TABLE public.t_prod_1 (
	id bigint,
	price integer,
	total_price numeric(30,7),
	midle_price numeric(30,7)
);

--change 1 first column types in table with changed deps
CREATE TABLE public.t_lot_prod_3 (
	id integer,
	price integer,
	total_price numeric(30,7),
	midle_price numeric(30,7)
);

ALTER TABLE public.t_lot_prod_3 OWNER TO khazieva_gr;

ALTER TABLE public.t_lot_prod_3
	ADD CONSTRAINT id_1 CHECK ((id > 0));

--change one column and add DEFAULT option
CREATE TABLE public.t_lod4 (
	field1 bigint,
	field3 bigint,
	field4 bigint
);

ALTER TABLE public.t_lod4 OWNER TO khazieva_gr;

--change 2 columns type & compression option
CREATE TABLE public.t33 (
	c0 integer,
	c1 integer COMPRESSION lz4,
	c2 integer
);

-- change identitiy and types
CREATE TABLE public.testIdentity (
    id bigint NOT NULL,--change type, drop identity
    c1 text NOT NULL, --change
    c11 text NOT NULL,--change
    c2 text NOT NULL, --change type, add identity
    c3 bigint
);

ALTER TABLE public.testIdentity ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
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
    c1 text STORAGE MAIN,--storage, type change
    c11 bigint NOT NULL,--type change
    c2 text NOT NULL,
    c3 bigint
);

-- comment change, types
CREATE TABLE public.comment_test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    new_col character varying(20) NOT NULL
);

COMMENT ON COLUMN public.comment_test.id IS 'id column';

-- option & type of column change, 2 near types change
CREATE TABLE public.test_options (
    id integer NOT NULL,
    field1 character(64),--type change
    field2 character(64),--type change
    field3 character(64),--type change
    field4 character(64),
    field5 character(64)
);
ALTER TABLE ONLY public.test_options ALTER COLUMN field1 SET (n_distinct=0.5, n_distinct_inherited=-0.75);

-- STATISTICS & type of column change
CREATE TABLE public.test_statistics (
    field1 integer,--type change
    field2 integer,--type change
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

ALTER TABLE ONLY public.test_statistics ALTER COLUMN field2 SET STATISTICS 100;

-- SEQUENCE & type of column change
CREATE TABLE public.testSeq (
    id integer NOT NULL,
    field1 character(64),
    field2 character(64)
);
ALTER TABLE public.testSeq ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME custom_named_seq
    START WITH 1
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
	field3 integer NOT NULL,
	field4 double precision,
	field5 numeric(30,6)
);

--change 2 near column types where collation change
CREATE TABLE public.testCollation (
	id integer COLLATE "de_DE",
	field1 integer,
	field2 bigint
);

--
-- PostgreSQL database dump complete
--