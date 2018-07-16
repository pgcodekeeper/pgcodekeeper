

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--CREATE SCHEMA public;


--ALTER SCHEMA public OWNER TO unit_test;


-- SCHEMA public GRANT

SET search_path = pg_catalog;

CREATE TYPE public.user_code AS (
    f1 integer,
    f2 text
);

ALTER TYPE public.user_code OWNER TO unit_test;

CREATE SEQUENCE public.emp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.emp_id_seq OWNER TO unit_test;

CREATE OR REPLACE FUNCTION public.emp_stamp() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        -- Check that empname and salary are given
        IF NEW.empname IS NULL THEN
            RAISE EXCEPTION 'empname cannot be null';
        END IF;
        IF NEW.salary IS NULL THEN
            RAISE EXCEPTION '% cannot have null salary', NEW.empname;
        END IF;

        -- Who works for us when they must pay for it?
        IF NEW.salary < 0 THEN
            RAISE EXCEPTION '% cannot have a negative salary', NEW.empname;
        END IF;

        -- Remember who changed the payroll when
        NEW.last_date := current_timestamp;
        NEW.last_user := current_user;
        RETURN NEW;
    END;
$$;

ALTER FUNCTION public.emp_stamp() OWNER TO unit_test;

CREATE OR REPLACE FUNCTION public.increment(i integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
        BEGIN
                RETURN i + 1;
        END;
$$;

ALTER FUNCTION public.increment(i integer) OWNER TO unit_test;

CREATE TABLE public.emp (
    id integer DEFAULT nextval('public.emp_id_seq'::regclass) NOT NULL,
    empname text,
    salary integer,
    last_date timestamp without time zone,
    last_user text,
    code user_code
);

ALTER TABLE public.emp OWNER TO unit_test;

CREATE UNIQUE INDEX name_ind ON public.emp USING btree (empname);

CREATE VIEW public.emp_view AS
    SELECT emp.empname,
    emp.last_date,
    increment(emp.salary) AS salary,
    emp.code
   FROM public.emp;

ALTER VIEW public.emp_view OWNER TO unit_test;

CREATE TRIGGER emp_stamp
    BEFORE INSERT OR UPDATE ON public.emp
    FOR EACH ROW
    EXECUTE PROCEDURE public.emp_stamp();

CREATE RULE notify_me AS
    ON UPDATE TO public.emp DO  NOTIFY emp;

ALTER SEQUENCE public.emp_id_seq
    OWNED BY public.emp.id;
    
    
REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

