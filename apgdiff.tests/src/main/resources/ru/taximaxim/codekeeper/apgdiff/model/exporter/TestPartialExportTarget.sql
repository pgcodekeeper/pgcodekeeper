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
-- Name: newschema; Type: SCHEMA; Schema: -; Owner: galiev_mr
--

CREATE SCHEMA newschema;


ALTER SCHEMA newschema OWNER TO galiev_mr;

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
        UPDATE t2 SET c6 = now() WHERE t2.c1 > 1;
    END;
$$;


ALTER FUNCTION public.fun1() OWNER TO galiev_mr;

--
-- Name: fun3(); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION public.fun3() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t3 SET c4 = 8 WHERE t3.c4 > 8;
    END;
$$;


ALTER FUNCTION public.fun3() OWNER TO galiev_mr;

--
-- Name: fun3(integer); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION public.fun3(i integer) RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t3 SET c4 = i WHERE t3.c4 > i;
    END;
$$;


ALTER FUNCTION public.fun3(i integer) OWNER TO galiev_mr;

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
-- Name: t3; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t3 (
    c1 integer NOT NULL,
    c2 text NOT NULL,
    c3 text,
    c4 integer,
    CONSTRAINT constr_t3 CHECK ((c4 > 0))
);


ALTER TABLE public.t3 OWNER TO galiev_mr;

--
-- Name: t4; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t4 (
    c1 integer NOT NULL,
    c2 text
);


ALTER TABLE public.t4 OWNER TO galiev_mr;

--
-- Name: t5; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.t5 (
    c1 integer NOT NULL,
    c2 text,
    c3 text
);


ALTER TABLE public.t5 OWNER TO galiev_mr;

--
-- Name: v1; Type: VIEW; Schema: public; Owner: galiev_mr
--

CREATE VIEW public.v1 AS
 SELECT t1.c1,
    t3.c2,
    t3.c3,
    t3.c4
   FROM public.t1, public.t3;


ALTER TABLE public.v1 OWNER TO galiev_mr;

--
-- Name: t1 c1; Type: DEFAULT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t1 ALTER COLUMN c1 SET DEFAULT nextval('public.t1_c1_seq'::regclass);


--
-- Name: t1 t1_c2_key; Type: CONSTRAINT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t1
    ADD CONSTRAINT t1_c2_key UNIQUE (c1, c2);


--
-- Name: t4 t4_c2_key; Type: CONSTRAINT; Schema: public; Owner: galiev_mr
--

ALTER TABLE ONLY public.t4
    ADD CONSTRAINT t4_c2_key UNIQUE (c2);


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
-- Name: t5_c1_idx; Type: INDEX; Schema: public; Owner: galiev_mr
--

CREATE INDEX t5_c1_idx ON public.t5 USING btree (c1) WITH (fillfactor='70');


--
-- Name: t1 t1_trigger; Type: TRIGGER; Schema: public; Owner: galiev_mr
--

CREATE TRIGGER t1_trigger AFTER INSERT ON public.t1 FOR EACH ROW EXECUTE PROCEDURE public.fun1();


--
-- Name: t3 t3_trigger; Type: TRIGGER; Schema: public; Owner: galiev_mr
--

CREATE TRIGGER t3_trigger AFTER INSERT ON public.t3 FOR EACH ROW EXECUTE PROCEDURE public.fun3();


CREATE TABLE public."t/1" (
    c1 integer
);

CREATE TABLE public."t_1" (
    c1 integer
);

CREATE TABLE public."t?1" (
    c1 integer
);

--
-- PostgreSQL database dump complete
--

