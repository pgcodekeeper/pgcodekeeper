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
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: add_restricted(integer, integer); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION add_restricted(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT PARALLEL RESTRICTED
    AS $_$select $1 + $2;$_$;


ALTER FUNCTION public.add_restricted(integer, integer) OWNER TO galiev_mr;

--
-- Name: add_safe(integer, integer); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION add_safe(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT PARALLEL SAFE
    AS $_$select $1 + $2;$_$;


ALTER FUNCTION public.add_safe(integer, integer) OWNER TO galiev_mr;

--
-- Name: add_unsafe(integer, integer); Type: FUNCTION; Schema: public; Owner: galiev_mr
--

CREATE FUNCTION add_unsafe(integer, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $1 + $2;$_$;


ALTER FUNCTION public.add_unsafe(integer, integer) OWNER TO galiev_mr;

--
-- PostgreSQL database dump complete
--

