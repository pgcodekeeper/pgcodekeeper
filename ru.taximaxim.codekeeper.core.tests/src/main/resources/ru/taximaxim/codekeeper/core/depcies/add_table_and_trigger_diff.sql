SET search_path = pg_catalog;

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
	BEFORE INSERT OR UPDATE ON public.emp
	FOR EACH ROW
	EXECUTE PROCEDURE test.emp_stamp();
