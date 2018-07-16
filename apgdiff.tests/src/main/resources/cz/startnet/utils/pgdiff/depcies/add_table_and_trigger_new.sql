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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: emp; Type: TABLE; Schema: public; Owner: galiev_mr
--

CREATE TABLE public.emp (
    empname text,
    salary integer,
    last_date timestamp without time zone,
    last_user text
);


ALTER TABLE public.emp OWNER TO galiev_mr;

--
-- Name: emp emp_stamp; Type: TRIGGER; Schema: public; Owner: galiev_mr
--

CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE ON public.emp FOR EACH ROW EXECUTE PROCEDURE test.emp_stamp();


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;


--
-- PostgreSQL database dump complete
--

