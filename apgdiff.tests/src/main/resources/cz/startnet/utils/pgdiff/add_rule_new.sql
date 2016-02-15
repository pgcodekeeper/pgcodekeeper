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


--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: 
--

CREATE PROCEDURAL LANGUAGE plpgsql;


SET search_path = public, pg_catalog;

--
-- Name: test_table_trigger(); Type: FUNCTION; Schema: public; Owner: fordfrog
--

CREATE FUNCTION test_table_rule_f() RETURNS "rule"
    AS $$
begin
	return NEW;
end;
$$
    LANGUAGE plpgsql;


ALTER FUNCTION public.test_table_rule_f() OWNER TO fordfrog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: test_table; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE TABLE test_table_rule (
    id serial NOT NULL
);


ALTER TABLE public.test_table OWNER TO fordfrog;

--
-- Name: test_table_trigger; Type: TRIGGER; Schema: public; Owner: fordfrog
--

CREATE RULE test_rule AS
	ON SELECT TO test_table_rule
    DO INSTEAD test_table_rule_f();


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

