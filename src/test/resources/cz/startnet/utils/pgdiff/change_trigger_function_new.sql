--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: another_triggers; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA another_triggers;


ALTER SCHEMA another_triggers OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = another_triggers, pg_catalog;


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


--
-- Name: test_table_trigger(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION test_table_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	return NEW;
end;
$$;


ALTER FUNCTION test_table_trigger() OWNER TO postgres;

--
-- Name: test_table; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE test_table (
    id integer NOT NULL
);


ALTER TABLE public.test_table OWNER TO postgres;


--
-- Name: test_table_trigger; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER test_table_trigger BEFORE INSERT OR UPDATE ON test_table FOR EACH ROW EXECUTE PROCEDURE test_table_trigger();


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

