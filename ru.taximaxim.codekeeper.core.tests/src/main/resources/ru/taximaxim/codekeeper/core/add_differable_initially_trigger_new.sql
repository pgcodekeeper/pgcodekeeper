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
-- Name: test_table; Type: TABLE; Schema: public; Owner: fordfrog; Tablespace: 
--

CREATE SEQUENCE public.test_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.test_table_id_seq OWNER TO shamsutdinov_lr;

CREATE TABLE public.test_table (
    id integer DEFAULT nextval('public.test_table_id_seq'::regclass) NOT NULL
);

ALTER TABLE public.test_table OWNER TO shamsutdinov_lr;

ALTER SEQUENCE public.test_table_id_seq
    OWNED BY public.test_table.id;

CREATE OR REPLACE FUNCTION public.test_table_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
 return NEW;
end;
$$;

ALTER FUNCTION public.test_table_trigger() OWNER TO shamsutdinov_lr;

CREATE CONSTRAINT TRIGGER test_table_trigger_differed
    AFTER INSERT OR UPDATE ON public.test_table
    FROM public.test_table
    DEFERRABLE INITIALLY DEFERRED
    FOR EACH ROW
    EXECUTE PROCEDURE public.test_table_trigger();
    
CREATE CONSTRAINT TRIGGER test_table_trigger_immediate
    AFTER INSERT OR UPDATE ON public.test_table
    FROM public.test_table
    DEFERRABLE INITIALLY IMMEDIATE
    FOR EACH ROW
    EXECUTE PROCEDURE public.test_table_trigger();

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

