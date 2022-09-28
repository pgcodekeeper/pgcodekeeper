CREATE SCHEMA test;

ALTER SCHEMA test OWNER TO galiev_mr;

CREATE TABLE public.emp (
    empname text,
    salary integer,
    last_date timestamp without time zone,
    last_user text
);

ALTER TABLE public.emp OWNER TO galiev_mr;


CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE ON public.emp FOR EACH ROW EXECUTE PROCEDURE test.emp_stamp();