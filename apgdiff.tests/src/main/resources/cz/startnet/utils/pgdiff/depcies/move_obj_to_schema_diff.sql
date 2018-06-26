SET search_path = pg_catalog;

DROP RULE notify_me ON public.emp;

DROP TRIGGER emp_stamp ON public.emp;

DROP VIEW public.emp_view;

DROP INDEX public.name_ind;

DROP TABLE public.emp;

DROP FUNCTION public.emp_stamp();

DROP FUNCTION public.increment(i integer);

DROP TYPE public.user_code;

CREATE TYPE test.user_code AS (
	f1 integer,
	f2 text
);

ALTER TYPE test.user_code OWNER TO galiev_mr;

CREATE SEQUENCE test.emp_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE test.emp_id_seq OWNER TO galiev_mr;

CREATE OR REPLACE FUNCTION test.emp_stamp() RETURNS trigger
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

ALTER FUNCTION test.emp_stamp() OWNER TO galiev_mr;

CREATE OR REPLACE FUNCTION test.increment(i integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
        BEGIN
                RETURN i + 1;
        END;
$$;

ALTER FUNCTION test.increment(i integer) OWNER TO galiev_mr;

CREATE TABLE test.emp (
	id integer DEFAULT nextval('test.emp_id_seq'::regclass) NOT NULL,
	empname text,
	salary integer,
	last_date timestamp without time zone,
	last_user text,
	code user_code
);

ALTER TABLE test.emp OWNER TO galiev_mr;

CREATE UNIQUE INDEX name_ind ON test.emp USING btree (empname);

CREATE VIEW test.emp_view AS
	SELECT emp.empname,
    emp.last_date,
    increment(emp.salary) AS salary,
    emp.code
   FROM test.emp;

ALTER VIEW test.emp_view OWNER TO galiev_mr;

CREATE TRIGGER emp_stamp
	BEFORE INSERT OR UPDATE ON test.emp
	FOR EACH ROW
	EXECUTE PROCEDURE test.emp_stamp();

CREATE RULE notify_me AS
    ON UPDATE TO test.emp DO  NOTIFY test.emp;

ALTER SEQUENCE test.emp_id_seq
	OWNED BY test.emp.id;
