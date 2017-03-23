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


SET search_path = public, pg_catalog;

--
-- Name: dom; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom AS integer NOT NULL DEFAULT (-1)
	CONSTRAINT dom_check CHECK ((VALUE <> 0));


ALTER DOMAIN dom OWNER TO botov_av;

--
-- Name: dom2; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom2 AS integer NOT NULL DEFAULT (-100)
	CONSTRAINT dom2_check CHECK ((VALUE < 1000));


ALTER DOMAIN dom2 OWNER TO botov_av;

--
-- Name: dom3; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom3 AS integer NOT NULL;


ALTER DOMAIN dom3 OWNER TO botov_av;

--
-- Name: dom3_1; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom3_1 AS integer NOT NULL;


ALTER DOMAIN dom3_1 OWNER TO botov_av;

--
-- Name: dom4; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom4 AS integer NOT NULL
	CONSTRAINT dom4_check CHECK ((VALUE <> 0));


ALTER DOMAIN dom4 OWNER TO botov_av;

--
-- Name: dom5; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom5 AS integer NOT NULL
	CONSTRAINT dom5_check CHECK ((VALUE <> 0))
	CONSTRAINT dom5_check1 CHECK ((VALUE <> (-1)))
	CONSTRAINT dom5_check2 CHECK ((VALUE <> 1));


ALTER DOMAIN dom5 OWNER TO botov_av;

--
-- Name: dom6; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom6 AS text COLLATE pg_catalog."ru_RU.utf8"
	CONSTRAINT dom6_check CHECK ((VALUE <> ''::text));


ALTER DOMAIN dom6 OWNER TO botov_av;

--
-- Name: dom8; Type: DOMAIN; Schema: public; Owner: botov_av
--

CREATE DOMAIN dom8 AS text COLLATE pg_catalog."ru_RU.utf8" NOT NULL DEFAULT 'NO DATA'::text
	CONSTRAINT dom8_check CHECK ((VALUE <> ''::text))
	CONSTRAINT dom8_check1 CHECK ((lower(VALUE) <> 'null'::text))
	CONSTRAINT dom8_check2 CHECK ((VALUE <> (0)::text));


ALTER DOMAIN dom8 OWNER TO botov_av;

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

