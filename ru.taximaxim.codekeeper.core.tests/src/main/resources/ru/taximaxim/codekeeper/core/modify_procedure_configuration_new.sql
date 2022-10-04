--
-- PostgreSQL database dump
--

--
-- Name: insert_data(); Type: PROCEDURE; Schema: public; Owner: shamsutdinov_lr
--

CREATE PROCEDURE public.insert_data()
    LANGUAGE sql
    SET "DateStyle" TO 'postgres, dmy'
    AS $$
INSERT INTO tbl VALUES (111);
INSERT INTO tbl VALUES (222);
$$;


ALTER PROCEDURE public.insert_data() OWNER TO shamsutdinov_lr;

--
-- Name: insert_data(integer, integer); Type: PROCEDURE; Schema: public; Owner: shamsutdinov_lr
--

CREATE PROCEDURE public.insert_data(a integer, b integer)
    LANGUAGE sql
    SET "DateStyle" TO 'postgres, dmy'
    AS $$
INSERT INTO tbl VALUES (a);
INSERT INTO tbl VALUES (b);
$$;

ALTER PROCEDURE public.insert_data(a integer, b integer) OWNER TO shamsutdinov_lr;

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

