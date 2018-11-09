--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = pg_catalog;

--
-- Name: insert_data(); Type: PROCEDURE; Schema: public; Owner: shamsutdinov_lr
--

CREATE PROCEDURE public.insert_data()
    LANGUAGE sql
    AS $$
INSERT INTO tbl VALUES (555);
$$;

ALTER PROCEDURE public.insert_data() OWNER TO shamsutdinov_lr;

--
-- Name: tbl; Type: TABLE; Schema: public; Owner: shamsutdinov_lr
--

CREATE TABLE public.tbl (
    c1 integer
);

ALTER TABLE public.tbl OWNER TO shamsutdinov_lr;

--
-- PostgreSQL database dump complete
--
