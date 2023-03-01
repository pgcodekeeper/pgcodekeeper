CREATE SCHEMA test;

CREATE FUNCTION public.fun1() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t2 SET c6 = now() WHERE t2.c1 > 0;
    END;
$$;

CREATE FUNCTION public.fun2() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t1 SET c6 = now() WHERE t1.c1 = 1;
    END;
$$;

CREATE FUNCTION public.proc(i integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t1 SET c6 = now() WHERE t1.c1 = i;
    END;
$$;

CREATE FUNCTION public.proc(i integer, t timestamp without time zone) RETURNS void
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t1 SET c6 = t WHERE t1.c1 = i;
    END;
$$;


SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE public.t1 (
    c1 integer NOT NULL,
    c2 text,
    c3 integer NOT NULL,
    c4 integer NOT NULL,
    c5 integer NOT NULL,
    c6 timestamp without time zone,
    CONSTRAINT constr_t1_c3 CHECK ((c3 > 0)),
    CONSTRAINT constr_t1_c4 CHECK (((c4 > 400) AND (c4 < 1000)))
);

CREATE SEQUENCE public.t1_c1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.t1_c1_seq OWNED BY public.t1.c1;

CREATE TABLE public.t2 (
    c1 integer NOT NULL,
    c2 text,
    c3 text,
    c4 integer NOT NULL,
    c5 integer NOT NULL,
    c6 timestamp without time zone,
    CONSTRAINT constr_t2 CHECK ((c4 > c5))
);

CREATE SEQUENCE public.t2_c1_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.t2_c1_seq OWNED BY public.t2.c1;

CREATE TABLE public.t3 (
    c1 integer NOT NULL,
    c2 text NOT NULL,
    c3 text,
    c4 integer
);

CREATE TABLE public.t4 (
    c1 integer NOT NULL,
    c2 integer NOT NULL DEFAULT 0
);

CREATE TABLE public.t5 (
    c1 integer NOT NULL,
    c2 text
);

CREATE TABLE test.test_table (
    c1 integer,
    c2 integer,
    c3 text,
    c4 date,
    c5 integer,
    CONSTRAINT contr_testtable_c5 CHECK ((c5 < 31))
);

CREATE TABLE test.test_table_2 (
    c1 integer,
    c2 text
);

ALTER TABLE ONLY public.t1 ALTER COLUMN c1 SET DEFAULT nextval('t1_c1_seq'::regclass);

ALTER TABLE ONLY public.t2 ALTER COLUMN c1 SET DEFAULT nextval('t2_c1_seq'::regclass);

ALTER TABLE ONLY public.t1
    ADD CONSTRAINT t1_c2_key UNIQUE (c2);

ALTER TABLE ONLY public.t4
    ADD CONSTRAINT t4_c2_key UNIQUE (c1, c2);

CREATE INDEX t1_c3_idx ON public.t1 USING btree (c3);

CREATE INDEX t1_c4_idx ON public.t1 USING btree (c4);

CREATE INDEX t1_c5_idx ON public.t1 USING btree (c5);

CREATE INDEX t2_c5_idx ON public.t2 USING btree (c5);

CREATE INDEX t5_c1_idx ON public.t5 USING btree (c1);

CREATE INDEX test_table_c1_idx ON test.test_table USING btree (c1);

CREATE INDEX test_table_c2_idx ON test.test_table USING btree (c2);

CREATE TRIGGER t1_trigger AFTER DELETE ON public.t1 FOR EACH ROW EXECUTE PROCEDURE fun1();

CREATE TRIGGER t2_trigger AFTER DELETE ON public.t2 FOR EACH ROW EXECUTE PROCEDURE fun2();