SET search_path = pg_catalog;

CREATE EXTENSION plpgsql SCHEMA pg_catalog;

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

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
    code public.user_code
);

ALTER TABLE public.emp OWNER TO unit_test;

CREATE UNIQUE INDEX name_ind ON public.emp USING btree (empname);

CREATE VIEW public.emp_view AS
    SELECT emp.empname,
    emp.last_date,
    public.increment(emp.salary) AS salary,
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
    
    
GRANT ALL ON SCHEMA public TO PUBLIC;

-- tests COLLATION

CREATE COLLATION public.ru (LOCALE = 'ru_RU.utf8', PROVIDER = libc);

ALTER COLLATION public.ru OWNER TO unit_test;

-- tests FOREIGN DATA WRAPPER

CREATE FOREIGN DATA WRAPPER dummy;

ALTER FOREIGN DATA WRAPPER dummy OWNER TO unit_test;

-- tests quoted server name

CREATE SERVER "asdashSA/sdag" FOREIGN DATA WRAPPER dummy;

ALTER SERVER "asdashSA/sdag" OWNER TO unit_test;

CREATE FOREIGN TABLE public.ft (
    c1 integer
)
SERVER "asdashSA/sdag";

ALTER FOREIGN TABLE public.ft OWNER TO unit_test;

-- tests USER MAPPING

CREATE USER MAPPING FOR PUBLIC SERVER myserver;

-- tests syntax sugar, alias, comments 

CREATE TABLE public.test (
    c1 integer NOT NULL, 
    c2 int UNIQUE,
    c3 text
);

ALTER TABLE public.test OWNER TO unit_test;

COMMENT ON TABLE public.test IS 'table comment';

COMMENT ON COLUMN public.test.c1 IS 'column comment';


-- tests constraint comments

ALTER TABLE public.test ADD CONSTRAINT test_pk_c1 PRIMARY KEY (c1);

COMMENT ON CONSTRAINT test_pk_c1 on public.test is 'constraint comment';

-- tests grant all with grant option

REVOKE ALL ON TABLE public.test FROM unit_test;
GRANT ALL ON TABLE public.test TO unit_test WITH GRANT OPTION;
GRANT ALL ON TABLE public.test TO postgres WITH GRANT OPTION;


-- tests rules

CREATE RULE r1 AS ON UPDATE TO public.test DO NOTIFY test;
CREATE RULE r2 AS ON INSERT TO public.test DO NOTHING;
CREATE RULE r3 AS ON DELETE TO public.test DO NOTHING;

ALTER TABLE public.test ENABLE REPLICA RULE r1;
ALTER TABLE public.test DISABLE RULE r2;
ALTER TABLE public.test ENABLE ALWAYS RULE r3;

COMMENT ON RULE r3 ON public.test IS 'test comment';

-- tests policy

CREATE POLICY p1 ON public.test AS RESTRICTIVE FOR SELECT TO unit_test USING (true);
CREATE POLICY p2 ON public.test AS PERMISSIVE FOR INSERT TO unit_test WITH CHECK ((1 > 0));
CREATE POLICY p3 ON public.test TO unit_test USING (true) WITH CHECK ((1 > 0));

COMMENT ON POLICY p1 ON public.test IS 'test comment';

-- tests full text search statements

CREATE TEXT SEARCH PARSER public.testparser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

COMMENT ON TEXT SEARCH PARSER public.testparser IS 'is test parser';


CREATE TEXT SEARCH TEMPLATE public.testtemplate (
    LEXIZE = dsnowball_lexize );

COMMENT ON TEXT SEARCH TEMPLATE public.testtemplate IS 'is test template';


CREATE TEXT SEARCH DICTIONARY public.testdictionary (
    TEMPLATE = text_search.testtemplate );

ALTER TEXT SEARCH DICTIONARY public.testdictionary OWNER TO unit_test;

COMMENT ON TEXT SEARCH DICTIONARY public.testdictionary IS 'is test dictionary';


CREATE TEXT SEARCH CONFIGURATION public.testconfig (
    PARSER = public.testconfig );

ALTER TEXT SEARCH CONFIGURATION public.testconfig OWNER TO unit_test;

COMMENT ON TEXT SEARCH CONFIGURATION public.testconfig IS 'is test configuration';

ALTER TEXT SEARCH CONFIGURATION public.testconfig
    ADD MAPPING FOR email WITH english_stem;

-- tests aggregate

CREATE AGGREGATE public.avg(double precision) (
    SFUNC = float8_accum,
    STYPE = double precision[],
    INITCOND = '{0,0,0}',
    FINALFUNC = float8_avg
);

ALTER AGGREGATE public.avg(double precision) OWNER TO unit_test;

COMMENT ON FUNCTION public.avg(double precision) IS 'is test aggregate';


-- tests schema

CREATE SCHEMA test;

ALTER SCHEMA test OWNER TO unit_test;

COMMENT ON SCHEMA test IS 'is test schema';

-- tests new sequences

CREATE TABLE public.seqtable (
    c1 bigint NOT NULL,
    c2 integer NOT NULL
);

ALTER TABLE public.seqtable OWNER TO unit_test;

ALTER TABLE public.seqtable ALTER COLUMN c1 ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.seqtable_c1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

ALTER TABLE public.seqtable ALTER COLUMN c2 ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.seqtable_c2_seq
    START WITH 5
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

-- tests partition tables


CREATE TABLE public.base (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.base OWNER TO unit_test;

CREATE TABLE public.child_ab PARTITION OF public.base
FOR VALUES IN ('a', 'b');
ALTER TABLE ONLY public.child_ab ALTER COLUMN c1 SET NOT NULL;

ALTER TABLE public.child_ab OWNER TO unit_test;


CREATE FOREIGN TABLE public.child_xz PARTITION OF public.base
FOR VALUES IN ('x', 'z')
SERVER "asdashSA/sdag";
ALTER TABLE ONLY public.child_xz ALTER COLUMN c1 SET NOT NULL;

ALTER FOREIGN TABLE public.child_xz OWNER TO unit_test;

-- tests mat view

CREATE MATERIALIZED VIEW public.mv1
WITH (fillfactor='90') AS
SELECT 1 AS first, 2 AS second
WITH NO DATA;

ALTER TABLE public.mv1 OWNER TO unit_test;

-- tests operators

CREATE FUNCTION public.pr(boolean, boolean) RETURNS boolean
    LANGUAGE sql IMMUTABLE
    AS $$ SELECT NULL::BOOLEAN; $$;

ALTER FUNCTION public.pr(boolean, boolean) OWNER TO unit_test;

CREATE OPERATOR public.=== (
    PROCEDURE = public.pr,
    LEFTARG = boolean,
    RIGHTARG = boolean,
    COMMUTATOR = OPERATOR(public.===),
    NEGATOR = OPERATOR(public.!==),
    MERGES,
    HASHES,
    JOIN = contjoinsel
);

ALTER OPERATOR public.=== (boolean, boolean) OWNER TO unit_test;

-- test casts

CREATE FUNCTION public.user_code(integer) RETURNS public.user_code
    LANGUAGE plpgsql
    AS $_$
begin
  return ($1, '')::public.user_code;
end;
$_$;

ALTER FUNCTION public.user_code(integer) OWNER TO unit_test;

CREATE CAST (integer AS public.user_code) WITH FUNCTION public.user_code(integer);

COMMENT ON CAST (integer AS public.user_code) IS 'cast comment';

CREATE SCHEMA country;

ALTER SCHEMA country OWNER TO unit_test;

CREATE SCHEMA worker;

ALTER SCHEMA worker OWNER TO unit_test;

CREATE TABLE country.city (
    id integer
);

ALTER TABLE country.city OWNER TO unit_test;

CREATE TABLE worker.people (
    fio text
);

ALTER TABLE worker.people OWNER TO unit_test;

CREATE TABLE worker.people_1 (
idfio text
);

ALTER TABLE worker.people_1 OWNER TO unit_test;

CREATE OR REPLACE FUNCTION country.get_city() RETURNS void
    LANGUAGE sql
    AS $$
    --function body
$$;

ALTER FUNCTION country.get_city() OWNER TO unit_test;

CREATE OR REPLACE FUNCTION public.people_worker_shedule() RETURNS void
    LANGUAGE sql
    AS $$
    --function body
$$;

ALTER FUNCTION public.people_worker_shedule() OWNER TO unit_test;

CREATE OR REPLACE FUNCTION worker.get_changes() RETURNS void
    LANGUAGE sql
    AS $$
$$;

ALTER FUNCTION worker.get_changes() OWNER TO unit_test;

CREATE SCHEMA ignore1;

ALTER SCHEMA ignore1 OWNER TO unit_test;

CREATE TABLE ignore1.testschema (
    fio text
);

ALTER TABLE ignore1.testschema OWNER TO unit_test;

CREATE OR REPLACE FUNCTION ignore1.get_schema() RETURNS void
    LANGUAGE sql
    AS $$
    --function body
$$;

ALTER FUNCTION ignore1.get_schema() OWNER TO unit_test;

CREATE SCHEMA ignoreI4vrw;

ALTER SCHEMA ignoreI4vrw OWNER TO unit_test;

CREATE TABLE ignoreI4vrw.testschema2 (
    fio text
);

ALTER TABLE ignoreI4vrw.testschema2 OWNER TO unit_test;

CREATE SCHEMA ignore;

ALTER SCHEMA ignore OWNER TO unit_test;

CREATE TABLE ignore.testtable (
    fio text
);

ALTER TABLE ignore.testtable OWNER TO unit_test;
