CREATE SCHEMA test;

CREATE TABLE test.emp (
    id integer NOT NULL,
    empname text,
    salary integer,
    last_date timestamp without time zone,
    last_user text,
    code test.user_code
);

ALTER TABLE test.emp OWNER TO galiev_mr;

ALTER TABLE ONLY test.emp ALTER COLUMN id SET DEFAULT nextval('test.emp_id_seq'::regclass);

CREATE VIEW test.emp_view AS
 SELECT emp.empname,
    emp.last_date,
    increment(emp.salary) AS salary,
    emp.code
   FROM test.emp;

ALTER TABLE test.emp_view OWNER TO galiev_mr;

CREATE UNIQUE INDEX name_ind ON test.emp USING btree (empname);

CREATE RULE notify_me AS
    ON UPDATE TO test.emp DO
 NOTIFY emp;

CREATE TRIGGER emp_stamp BEFORE INSERT OR UPDATE ON test.emp FOR EACH ROW EXECUTE PROCEDURE test.emp_stamp();