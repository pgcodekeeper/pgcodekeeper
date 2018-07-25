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
-- Name: accounts; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE public.accounts (
    text text,
    number integer,
    number2 integer
);

ALTER TABLE public.accounts OWNER TO shamsutdinov_lr;

--
-- Name: logs; Type: TABLE; Schema: public; Owner: shamsutdinov_lr; Tablespace: 
--

CREATE TABLE public.logs (
    action text,
    text text,
    number integer
);

ALTER TABLE public.logs OWNER TO shamsutdinov_lr;

--

CREATE OR REPLACE FUNCTION public.log_account_update() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    text text;
    numbers integer;
BEGIN
    IF    TG_OP = 'INSERT' THEN
        INSERT INTO logs values ('INSERT', NEW.text, NEW.number);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO logs values ('UPDATE', NEW.text, NEW.number);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO logs values ('DELETE', OLD.text, OLD.number);
        RETURN NEW;
    END IF;
END;
$$;

ALTER FUNCTION public.log_account_update() OWNER TO shamsutdinov_lr;

--

CREATE TRIGGER log_update
    AFTER UPDATE ON public.accounts
    FOR EACH ROW
    WHEN ((old.number IS DISTINCT FROM new.number))
    EXECUTE PROCEDURE public.log_account_update();

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

