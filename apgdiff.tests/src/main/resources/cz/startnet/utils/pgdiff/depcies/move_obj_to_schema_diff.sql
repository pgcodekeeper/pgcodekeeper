DROP RULE notify_me ON emp;

DROP TRIGGER emp_stamp ON emp;

DROP VIEW emp_view;

DROP INDEX name_ind;

DROP TABLE emp;

DROP FUNCTION emp_stamp();

DROP FUNCTION increment(i integer);

DROP TYPE user_code;

SET search_path = test, pg_catalog;

CREATE TYPE user_code AS (
	f1 integer,
	f2 text
);

ALTER TYPE user_code OWNER TO galiev_mr;

CREATE SEQUENCE emp_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE emp_id_seq OWNER TO galiev_mr;

CREATE OR REPLACE FUNCTION emp_stamp() RETURNS trigger
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

CREATE OR REPLACE FUNCTION increment(i integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
        BEGIN
                RETURN i + 1;
        END;
$$;

CREATE TABLE emp (
	id integer DEFAULT nextval('emp_id_seq'::regclass) NOT NULL,
	empname text,
	salary integer,
	last_date timestamp without time zone,
	last_user text,
	code user_code
);

ALTER TABLE emp OWNER TO galiev_mr;

CREATE UNIQUE INDEX name_ind ON emp USING btree (empname);

CREATE VIEW emp_view AS
	SELECT emp.empname,
    emp.last_date,
    increment(emp.salary) AS salary,
    emp.code
   FROM emp;

ALTER VIEW emp_view OWNER TO galiev_mr;

CREATE TRIGGER emp_stamp
	BEFORE INSERT OR UPDATE ON emp
	FOR EACH ROW
	EXECUTE PROCEDURE emp_stamp();

CREATE RULE notify_me AS
    ON UPDATE TO emp DO  NOTIFY emp;

ALTER SEQUENCE emp_id_seq
	OWNED BY emp.id;
