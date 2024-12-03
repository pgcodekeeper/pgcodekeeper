SET search_path = pg_catalog;

-- DEPCY: This VIEW emp_view depends on the TABLE: public.emp

DROP VIEW public.emp_view;

-- DEPCY: This RULE notify_me depends on the TABLE: public.emp

DROP RULE notify_me ON public.emp;

-- DEPCY: This TRIGGER emp_stamp depends on the TABLE: public.emp

DROP TRIGGER emp_stamp ON public.emp;

-- DEPCY: This INDEX name_ind depends on the TABLE: public.emp

DROP INDEX public.name_ind;

DROP TABLE public.emp;

-- DEPCY: This SEQUENCE emp_id_seq is a dependency of COLUMN: test.emp.id

CREATE SEQUENCE test.emp_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE test.emp_id_seq OWNER TO galiev_mr;

-- DEPCY: This TYPE user_code is a dependency of COLUMN: test.emp.code

CREATE TYPE test.user_code AS (
	f1 integer,
	f2 text
);

ALTER TYPE test.user_code OWNER TO galiev_mr;

CREATE TABLE test.emp (
	id integer DEFAULT nextval('test.emp_id_seq'::regclass) NOT NULL,
	empname text,
	salary integer,
	last_date timestamp without time zone,
	last_user text,
	code test.user_code
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

-- DEPCY: This FUNCTION emp_stamp is a dependency of TRIGGER: test.emp.emp_stamp

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

CREATE TRIGGER emp_stamp
	BEFORE INSERT OR UPDATE ON test.emp
	FOR EACH ROW
	EXECUTE PROCEDURE test.emp_stamp();

CREATE RULE notify_me AS
    ON UPDATE TO test.emp DO  NOTIFY emp;

ALTER SEQUENCE test.emp_id_seq
	OWNED BY test.emp.id;