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

CREATE SCHEMA tester;

ALTER SCHEMA tester OWNER TO shamsutdinov_lr;

CREATE SCHEMA tester2;

ALTER SCHEMA tester2 OWNER TO shamsutdinov_lr;

--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: 
--

CREATE PROCEDURAL LANGUAGE plpgsql;


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE OR REPLACE FUNCTION tester.nonull_append_strings(text, text) RETURNS boolean
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 IS NULL THEN FALSE
            WHEN $2 IS NULL THEN FALSE
            ELSE TRUE
            END;
    $_$;

ALTER FUNCTION tester.nonull_append_strings(text, text) OWNER TO shamsutdinov_lr;

--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
