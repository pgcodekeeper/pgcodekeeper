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


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: mytable; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE public.mytable (
    col111 numeric,
    col222 integer,
    col333 text
);

ALTER TABLE public.mytable OWNER TO shamsutdinov_lr;

CREATE UNIQUE INDEX col222_idx ON public.mytable USING btree (col222) WHERE (col111 > 100);

--
-- Name: mytable2; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE public.mytable2 (
    col111 integer,
    col222 numeric,
    col333 text
);

ALTER TABLE public.mytable2 OWNER TO shamsutdinov_lr;

CREATE UNIQUE INDEX col222_idx_2 ON public.mytable2 USING btree (col222) WHERE (col111 > 100);

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

