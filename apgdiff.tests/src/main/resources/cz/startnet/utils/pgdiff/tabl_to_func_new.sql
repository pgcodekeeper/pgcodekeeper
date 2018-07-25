
SET search_path = pg_catalog;

--
-- Name: testf(); Type: FUNCTION; Schema: public; Owner: botov_av
--

CREATE FUNCTION public.testf() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;


ALTER FUNCTION public.testf() OWNER TO botov_av;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1; Type: TABLE; Schema: public; Owner: botov_av; Tablespace: 
--

CREATE TABLE public.t1 (
    c1 integer DEFAULT public.testf()
);


ALTER TABLE public.t1 OWNER TO botov_av;
