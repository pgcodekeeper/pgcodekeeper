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

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = pg_catalog;

--
-- Name: test_table_trigger_another(); Type: FUNCTION; Schema: another_triggers; Owner: postgres
--

CREATE FUNCTION another_triggers.test_table_trigger_another() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	return NEW;
end;
$$;


ALTER FUNCTION another_triggers.test_table_trigger_another() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: test_table; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.test_table (
    id integer NOT NULL
);


ALTER TABLE public.test_table OWNER TO postgres;


--
-- Name: test_table_trigger; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER test_table_trigger BEFORE INSERT OR UPDATE ON public.test_table FOR EACH ROW EXECUTE PROCEDURE another_triggers.test_table_trigger_another();


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

