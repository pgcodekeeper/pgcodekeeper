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

CREATE TYPE typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU",
	val text COLLATE pg_catalog."en_GB.utf8"
);


ALTER TYPE typ_composite OWNER TO botov_av;

--
-- Name: add(typ_composite, integer); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION add(typ_composite, integer) RETURNS integer
    LANGUAGE sql IMMUTABLE STRICT
    AS $_$select $2;$_$;


ALTER FUNCTION public.add(typ_composite, integer) OWNER TO botov_av;

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

