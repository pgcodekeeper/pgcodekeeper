--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

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
-- Name: user_code; Type: TYPE; Schema: test; Owner: galiev_mr
--

CREATE TYPE test.user_code AS (
    f1 integer,
    f2 text
);


ALTER TYPE test.user_code OWNER TO galiev_mr;

--
-- Name: emp_stamp(); Type: FUNCTION; Schema: test; Owner: galiev_mr
--

CREATE FUNCTION test.emp_stamp() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        -- Check that empname and salary are given
        IF NEW.empname IS NULL THEN
            RAISE EXCEPTION 'empname cannot be null';
        END IF;
        IF NEW.salary IS NULL THEN
            RAISE EXCEPTION '% cannot have null salary', NEW.empname;
        END IF;

        -- Who works for us when they must pay for it?
        IF NEW.salary < 0 THEN
            RAISE EXCEPTION '% cannot have a negative salary', NEW.empname;
        END IF;

        -- Remember who changed the payroll when
        NEW.last_date := current_timestamp;
        NEW.last_user := current_user;
        RETURN NEW;
    END;
$$;


ALTER FUNCTION test.emp_stamp() OWNER TO galiev_mr;

--
-- Name: increment(integer); Type: FUNCTION; Schema: test; Owner: galiev_mr
--

CREATE FUNCTION test.increment(i integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
        BEGIN
                RETURN i + 1;
        END;
$$;


ALTER FUNCTION test.increment(i integer) OWNER TO galiev_mr;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: emp; Type: TABLE; Schema: test; Owner: galiev_mr
--

CREATE TABLE test.emp (
    id integer NOT NULL,
    empname text,
    salary integer,
    last_date timestamp without time zone,
    last_user text,
    code test.user_code
);


ALTER TABLE test.emp OWNER TO galiev_mr;

--
-- Name: emp_id_seq; Type: SEQUENCE; Schema: test; Owner: galiev_mr
--

CREATE SEQUENCE test.emp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE test.emp_id_seq OWNER TO galiev_mr;

--
-- Name: emp_id_seq; Type: SEQUENCE OWNED BY; Schema: test; Owner: galiev_mr
--

ALTER SEQUENCE test.emp_id_seq OWNED BY test.emp.id;


--
-- Name: emp_view; Type: VIEW; Schema: test; Owner: galiev_mr
--

CREATE VIEW test.emp_view AS
 SELECT emp.empname,
    emp.last_date,
    increment(emp.salary) AS salary,
    emp.code
   FROM test.emp;


ALTER TABLE test.emp_view OWNER TO galiev_mr;

--
-- Name: emp id; Type: DEFAULT; Schema: test; Owner: galiev_mr
--

ALTER TABLE ONLY test.emp ALTER COLUMN id SET DEFAULT nextval('test.emp_id_seq'::regclass);


--
-- Name: name_ind; Type: INDEX; Schema: test; Owner: galiev_mr
--

CREATE UNIQUE INDEX name_ind ON test.emp USING btree (empname);


--
-- Name: emp notify_me; Type: RULE; Schema: test; Owner: galiev_mr
--

CREATE RULE notify_me AS
    ON UPDATE TO test.emp DO
 NOTIFY emp;


--
-- Name: emp emp_stamp; Type: TRIGGER; Schema: public; Owner: galiev_mr
--

CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE ON test.emp FOR EACH ROW EXECUTE PROCEDURE test.emp_stamp();


--
-- PostgreSQL database dump complete
--

