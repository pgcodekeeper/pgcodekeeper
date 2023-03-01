CREATE SCHEMA newschema;

CREATE FUNCTION public.fun1() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t2 SET c6 = now() WHERE t2.c1 > 1;
    END;
$$;

CREATE FUNCTION public.fun3() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t3 SET c4 = 8 WHERE t3.c4 > 8;
    END;
$$;

CREATE FUNCTION public.fun3(i integer) RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        UPDATE t3 SET c4 = i WHERE t3.c4 > i;
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

CREATE TABLE public.t3 (
    c1 integer NOT NULL,
    c2 text NOT NULL,
    c3 text,
    c4 integer,
    CONSTRAINT constr_t3 CHECK ((c4 > 0))
);

CREATE TABLE public.t4 (
    c1 integer NOT NULL,
    c2 integer DEFAULT 1
);

CREATE TABLE public.t5 (
    c1 integer NOT NULL,
    c2 text,
    c3 text
);

CREATE VIEW public.v1 AS
 SELECT t1.c1,
    t3.c2,
    t3.c3,
    t3.c4
   FROM public.t1, public.t3;

ALTER TABLE ONLY public.t1 ALTER COLUMN c1 SET DEFAULT nextval('t1_c1_seq'::regclass);

ALTER TABLE ONLY public.t1
    ADD CONSTRAINT t1_c2_key UNIQUE (c1, c2);

ALTER TABLE ONLY public.t4
    ADD CONSTRAINT t4_c2_key UNIQUE (c2);

CREATE INDEX t1_c3_idx ON public.t1 USING btree (c3);

CREATE INDEX t1_c4_idx ON public.t1 USING btree (c4);

CREATE INDEX t1_c5_idx ON public.t1 USING btree (c5);

CREATE INDEX t5_c1_idx ON public.t5 USING btree (c1) WITH (fillfactor='70');

CREATE TRIGGER t1_trigger AFTER INSERT ON public.t1 FOR EACH ROW EXECUTE PROCEDURE fun1();

CREATE TRIGGER t3_trigger AFTER INSERT ON public.t3 FOR EACH ROW EXECUTE PROCEDURE fun3();