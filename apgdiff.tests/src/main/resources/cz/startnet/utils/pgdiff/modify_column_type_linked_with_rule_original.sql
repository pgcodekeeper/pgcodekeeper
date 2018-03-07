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


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: accounts; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE accounts (
    text text,
    number integer,
    number2 integer
);

ALTER TABLE accounts OWNER TO shamsutdinov_lr;

--
-- Name: accounts2; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE accounts2 (
    text text,
    number integer,
    number2 integer
);

ALTER TABLE accounts2 OWNER TO shamsutdinov_lr;

--
-- Name: accounts3; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE accounts3 (
    text text,
    number integer,
    number2 integer
);

ALTER TABLE accounts3 OWNER TO shamsutdinov_lr;

--
-- Name: one1; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE one1 (
    col11 character varying,
    col222222 character varying
);

ALTER TABLE one1 OWNER TO shamsutdinov_lr;

-----------------------------------------------------------------------------

CREATE RULE protect_accounts AS
    ON UPDATE TO accounts
  WHERE (old.number2 = 100) DO INSTEAD  
  INSERT INTO one1 (col11)  SELECT (new.number + 1);

CREATE RULE protect_accounts2 AS
    ON UPDATE TO accounts2
  WHERE (old.number2 = 100) DO INSTEAD  
  INSERT INTO one1 (col11)  SELECT (new.number + 1);

CREATE RULE protect_accounts3 AS
    ON UPDATE TO accounts3
  WHERE (old.number2 = 100) DO INSTEAD  
  INSERT INTO one1 (col222222)  SELECT (new.number + 1);


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

