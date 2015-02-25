--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET search_path = public, pg_catalog;

--
-- Name: typ_composite; Type: TYPE; Schema: public; Owner: botov_av
--

CREATE TYPE typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU"
);


ALTER TYPE typ_range OWNER TO botov_av;

--
-- Name: add(typ_composite, integer); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION add(typ_range, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;


ALTER FUNCTION public.add(typ_range, integer) OWNER TO botov_av;

SET default_tablespace = '';

SET default_with_oids = false;

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

