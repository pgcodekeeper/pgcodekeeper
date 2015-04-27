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
-- Name: test_schema; Type: SCHEMA; Schema: -; Owner: botov_av
--

CREATE SCHEMA test_schema;


ALTER SCHEMA test_schema OWNER TO botov_av;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: dom; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));


ALTER DOMAIN public.dom OWNER TO botov_av;

--
-- Name: typ_composite; Type: TYPE; Schema: public; Owner: botov_av
--

CREATE TYPE typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);


ALTER TYPE public.typ_composite OWNER TO botov_av;

--
-- Name: test_fnc(character varying); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;


ALTER FUNCTION public.test_fnc(arg character varying) OWNER TO botov_av;

--
-- Name: trigger_fnc(); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;


ALTER FUNCTION public.trigger_fnc() OWNER TO botov_av;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: test; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);


ALTER TABLE public.test OWNER TO botov_av;

--
-- Name: test_id_seq; Type: SEQUENCE; Schema: public; Owner: botov_av
--

CREATE SEQUENCE test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_id_seq OWNER TO botov_av;

--
-- Name: test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: botov_av
--

ALTER SEQUENCE test_id_seq OWNED BY test.id;


--
-- Name: test_view; Type: VIEW; Schema: public; Owner: botov_av
--

CREATE VIEW test_view AS
 SELECT test.id,
    test.text
   FROM test;


ALTER TABLE public.test_view OWNER TO botov_av;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: botov_av
--

ALTER TABLE ONLY test ALTER COLUMN id SET DEFAULT nextval('test_id_seq'::regclass);


--
-- Name: test_pkey; Type: CONSTRAINT; Schema: public; Owner: botov_av; Tablespace: 
--

ALTER TABLE ONLY test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


--
-- Name: test_trigger; Type: TRIGGER; Schema: public; Owner: botov_av
--

CREATE TRIGGER test_trigger BEFORE UPDATE ON test FOR EACH STATEMENT EXECUTE PROCEDURE trigger_fnc();


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- Name: test_schema; Type: ACL; Schema: -; Owner: botov_av
--

REVOKE ALL ON SCHEMA test_schema FROM PUBLIC;
REVOKE ALL ON SCHEMA test_schema FROM botov_av;
GRANT ALL ON SCHEMA test_schema TO botov_av;
GRANT ALL ON SCHEMA test_schema TO maindb;


--
-- Name: dom; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON TYPE dom FROM PUBLIC;
REVOKE ALL ON TYPE dom FROM botov_av;
GRANT ALL ON TYPE dom TO botov_av;
GRANT ALL ON TYPE dom TO PUBLIC;
GRANT ALL ON TYPE dom TO maindb;


--
-- Name: typ_composite; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON TYPE typ_composite FROM PUBLIC;
REVOKE ALL ON TYPE typ_composite FROM botov_av;
GRANT ALL ON TYPE typ_composite TO botov_av;
GRANT ALL ON TYPE typ_composite TO PUBLIC;
GRANT ALL ON TYPE typ_composite TO maindb;


--
-- Name: test_fnc(character varying); Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM PUBLIC;
REVOKE ALL ON FUNCTION test_fnc(arg character varying) FROM botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO botov_av;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO PUBLIC;
GRANT ALL ON FUNCTION test_fnc(arg character varying) TO maindb;


--
-- Name: trigger_fnc(); Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON FUNCTION trigger_fnc() FROM PUBLIC;
REVOKE ALL ON FUNCTION trigger_fnc() FROM botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO botov_av;
GRANT ALL ON FUNCTION trigger_fnc() TO PUBLIC;
GRANT ALL ON FUNCTION trigger_fnc() TO maindb;


--
-- Name: test; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON TABLE test FROM PUBLIC;
REVOKE ALL ON TABLE test FROM botov_av;
GRANT ALL ON TABLE test TO botov_av;
GRANT ALL ON TABLE test TO maindb;


--
-- Name: test.id; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL(id) ON TABLE test FROM PUBLIC;
REVOKE ALL(id) ON TABLE test FROM botov_av;
GRANT ALL(id) ON TABLE test TO maindb;


--
-- Name: test_id_seq; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON SEQUENCE test_id_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE test_id_seq FROM botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO botov_av;
GRANT ALL ON SEQUENCE test_id_seq TO maindb;


--
-- Name: test_view; Type: ACL; Schema: public; Owner: botov_av
--

REVOKE ALL ON TABLE test_view FROM PUBLIC;
REVOKE ALL ON TABLE test_view FROM botov_av;
GRANT ALL ON TABLE test_view TO botov_av;
GRANT ALL ON TABLE test_view TO maindb;


--
-- PostgreSQL database dump complete
--

