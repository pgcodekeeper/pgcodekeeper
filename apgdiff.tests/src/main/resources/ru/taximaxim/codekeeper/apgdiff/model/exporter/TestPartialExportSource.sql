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
-- Name: test; Type: SCHEMA; Schema: -; Owner: galiev_mr
--

CREATE SCHEMA test;


ALTER SCHEMA test OWNER TO galiev_mr;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = pg_catalog;

--
-- Name: fun1(); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION public.fun1() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t2 SET c6 = now() WHERE t2.c1 > 0;
    END;
$$;


ALTER FUNCTION public.fun1() OWNER TO galiev_mr;

--
-- Name: fun2(); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION public.fun2() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t1 SET c6 = now() WHERE t1.c1 = 1;
    END;
$$;


ALTER FUNCTION public.fun2() OWNER TO galiev_mr;

--
-- Name: proc(integer); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION public.proc(i integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t1 SET c6 = now() WHERE t1.c1 = i;
    END;
$$;


ALTER FUNCTION public.proc(i integer) OWNER TO galiev_mr;

--
-- Name: proc(integer, timestamp without time zone); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION public.proc(i integer, t timestamp without time zone) RETURNS void
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t1 SET c6 = t WHERE t1.c1 = i;
    END;
$$;


ALTER FUNCTION public.proc(i integer, t timestamp without time zone) OWNER TO galiev_mr;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t1 (
    c1 integer NOT NULL,
    c2 text,
    c3 integer NOT NULL,
    c4 integer NOT NULL,
    c5 integer NOT NULL,
    c6 timestamp without time zone,
    CONSTRAINT constr_t1_c3 CHECK ((c3 > 0)),
    CONSTRAINT constr_t1_c4 CHECK (((c4 > 400) AND (c4 < 1000)))
);


ALTER TABLE public.t1 OWNER TO galiev_mr;

--
-- Name: t1_c1_seq; Type: SEQUENCE; Schema: public; Owner: galiev_mr
--

CREATE SEQUENCE public.t1_c1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t1_c1_seq OWNER TO galiev_mr;

--
-- Name: t1_c1_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: galiev_mr
--

ALTER SEQUENCE public.t1_c1_seq OWNED BY public.t1.c1;


--
-- Name: t2; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t2 (
    c1 integer NOT NULL,
    c2 text,
    c3 text,
    c4 integer NOT NULL,
    c5 integer NOT NULL,
    c6 timestamp without time zone,
    CONSTRAINT constr_t2 CHECK ((c4 > c5))
);


ALTER TABLE public.t2 OWNER TO galiev_mr;

--
-- Name: t2_c1_seq; Type: SEQUENCE; Schema: public; Owner: galiev_mr
--

CREATE SEQUENCE public.t2_c1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t2_c1_seq OWNER TO galiev_mr;

--
-- Name: t2_c1_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: galiev_mr
--

ALTER SEQUENCE public.t2_c1_seq OWNED BY public.t2.c1;


--
-- Name: t3; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t3 (
    c1 integer NOT NULL,
    c2 text NOT NULL,
    c3 text,
    c4 integer
);


ALTER TABLE public.t3 OWNER TO galiev_mr;

--
-- Name: t4; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t4 (
    c1 integer NOT NULL,
    c2 integer NOT NULL
);


ALTER TABLE public.t4 OWNER TO galiev_mr;

--
-- Name: t5; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t5 (
    c1 integer NOT NULL,
    c2 text
);


ALTER TABLE public.t5 OWNER TO galiev_mr;


--
-- Name: test_table; Type: TABLE; Schema: test; Owner: galiev_mr
--

CREATE TABLE test.test_table (
    c1 integer,
    c2 integer,
    c3 text,
    c4 date,
    c5 integer,
    CONSTRAINT contr_testtable_c5 CHECK ((c5 < 31))
);


ALTER TABLE test.test_table OWNER TO galiev_mr;

--
-- Name: test_table_2; Type: TABLE; Schema: test; Owner: galiev_mr
--

CREATE TABLE test.test_table_2 (
    c1 integer,
    c2 text
);


ALTER TABLE test.test_table_2 OWNER TO galiev_mr;

--
-- Name: t1 c1; Type: DEFAULT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t1 ALTER COLUMN c1 SET DEFAULT nextval('public.t1_c1_seq'::regclass);


--
-- Name: t2 c1; Type: DEFAULT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t2 ALTER COLUMN c1 SET DEFAULT nextval('public.t2_c1_seq'::regclass);


--
-- Name: t1 t1_c2_key; Type: CONSTRAINT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t1
    ADD CONSTRAINT t1_c2_key UNIQUE (c2);


--
-- Name: t4 t4_c2_key; Type: CONSTRAINT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t4
    ADD CONSTRAINT t4_c2_key UNIQUE (c1, c2);


--
-- Name: t1_c3_idx; Type: INDEX; Schema: public; Owner: galiev_mr
--

CREATE INDEX t1_c3_idx ON public.t1 USING btree (c3);


--
-- Name: t1_c4_idx; Type: INDEX; Schema: public; Owner: galiev_mr
--

CREATE INDEX t1_c4_idx ON public.t1 USING btree (c4);


--
-- Name: t1_c5_idx; Type: INDEX; Schema: public; Owner: galiev_mr
--

CREATE INDEX t1_c5_idx ON public.t1 USING btree (c5);


--
-- Name: t2_c5_idx; Type: INDEX; Schema: public; Owner: galiev_mr
--

CREATE INDEX t2_c5_idx ON public.t2 USING btree (c5);


--
-- Name: t5_c1_idx; Type: INDEX; Schema: public; Owner: galiev_mr
--

CREATE INDEX t5_c1_idx ON public.t5 USING btree (c1);


--
-- Name: test_table_c1_idx; Type: INDEX; Schema: test; Owner: galiev_mr
--

CREATE INDEX test_table_c1_idx ON test.test_table USING btree (c1);


--
-- Name: test_table_c2_idx; Type: INDEX; Schema: test; Owner: galiev_mr
--

CREATE INDEX test_table_c2_idx ON test.test_table USING btree (c2);


--
-- Name: t1 t1_trigger; Type: TRIGGER; Schema: public; Owner: galiev_mr
--

CREATE TRIGGER t1_trigger AFTER DELETE ON public.t1 FOR EACH ROW EXECUTE PROCEDURE public.fun1();


--
-- Name: t2 t2_trigger; Type: TRIGGER; Schema: public; Owner: galiev_mr
--

CREATE TRIGGER t2_trigger AFTER DELETE ON public.t2 FOR EACH ROW EXECUTE PROCEDURE public.fun2();


--
-- PostgreSQL database dump complete
--
