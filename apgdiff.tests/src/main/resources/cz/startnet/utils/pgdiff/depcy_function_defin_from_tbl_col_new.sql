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

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: emp; Type: TABLE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TABLE public.emp (
    name text,
    salary integer,
    age integer,
    cubicle point
);

ALTER TABLE public.emp OWNER TO shamsutdinov_lr;

--
-- Name: double_salary(public.emp); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.double_salary(public.emp) RETURNS numeric
    LANGUAGE sql
    AS $_$
    SELECT ($1.salary * 2)::numeric AS salary;
$_$;

ALTER FUNCTION public.double_salary(public.emp) OWNER TO shamsutdinov_lr;

--
-- Name: double_salary_2(public.emp); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.double_salary_2(nnaammee public.emp) RETURNS numeric
    LANGUAGE sql
    AS $$
    SELECT (nnaammee.salary * 2)::numeric AS salary;
$$;

ALTER FUNCTION public.double_salary_2(nnaammee public.emp) OWNER TO shamsutdinov_lr;

--
-- Name: double_salary_3(public.emp); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.double_salary_3(public.emp) RETURNS numeric
    LANGUAGE sql
    AS $_$
    SELECT ($1.age * 6546654654)::numeric AS tteesstt;
$_$;

ALTER FUNCTION public.double_salary_3(public.emp) OWNER TO shamsutdinov_lr;

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

