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

--CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = pg_catalog;

--
-- Name: dom; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));


ALTER DOMAIN public.dom OWNER TO botov_av;

--
-- Name: typ_composite; Type: TYPE; Schema: public; Owner: botov_av
--

CREATE TYPE public.typ_composite AS (
	key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
	val text COLLATE pg_catalog."en_GB"
);


ALTER TYPE public.typ_composite OWNER TO botov_av;

--
-- Name: test_fnc(character varying); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;


ALTER FUNCTION public.test_fnc(arg character varying) OWNER TO botov_av;

--
-- Name: trigger_fnc(); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;


ALTER FUNCTION public.trigger_fnc() OWNER TO botov_av;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: test; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE public.test (
    id integer NOT NULL,
    text character varying(20) NOT NULL,
    CONSTRAINT text_check CHECK ((length((text)::text) > 0))
);


ALTER TABLE public.test OWNER TO botov_av;

--
-- Name: test_id_seq; Type: SEQUENCE; Schema: public; Owner: botov_av
--

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_id_seq OWNER TO botov_av;

--
-- Name: test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: botov_av
--

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;


--
-- Name: test_view; Type: VIEW; Schema: public; Owner: botov_av
--

CREATE VIEW public.test_view AS
 SELECT test.id,
    test.text
   FROM public.test;


ALTER TABLE public.test_view OWNER TO botov_av;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: botov_av
--

ALTER TABLE ONLY public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);


--
-- Name: test_pkey; Type: CONSTRAINT; Schema: public; Owner: botov_av; Tablespace: 
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


--
-- Name: test_trigger; Type: TRIGGER; Schema: public; Owner: botov_av
--

CREATE TRIGGER test_trigger BEFORE UPDATE ON public.test FOR EACH STATEMENT EXECUTE PROCEDURE public.trigger_fnc();


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

