CREATE SCHEMA dblink;

ALTER SCHEMA dblink OWNER TO unit_test;

COMMENT ON SCHEMA dblink IS 'This is test schema';

CREATE DOMAIN public.dom1 AS text COLLATE pg_catalog."ru_RU.utf8" NOT NULL DEFAULT 'as'::text
    CONSTRAINT dom1_check CHECK ((VALUE <> ''::text));

ALTER DOMAIN public.dom1 OWNER TO unit_test;

COMMENT ON DOMAIN public.dom1 IS 'This is test domain';

CREATE TYPE public.typ_composite AS (
    key character varying(80) COLLATE pg_catalog."ru_RU.utf8",
    val text COLLATE pg_catalog."en_GB"
);

ALTER TYPE public.typ_composite OWNER TO unit_test;

COMMENT ON TYPE public.typ_composite IS 'this is test composite type';

COMMENT ON COLUMN public.typ_composite."key" IS 'Type composite key comment';

CREATE TYPE public.typ_enum AS ENUM (
    'wat',
    'wut',
    'weed'
);

ALTER TYPE public.typ_enum OWNER TO unit_test;

CREATE TYPE public.typ_range AS RANGE (
    subtype = character varying,
    collation = pg_catalog."ru_RU.utf8"
);

ALTER TYPE public.typ_range OWNER TO unit_test;

CREATE FUNCTION public.trfunc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN RETURN 1; END; $$;

ALTER FUNCTION public.trfunc() OWNER TO unit_test;

CREATE FUNCTION public.add1(integer, integer) RETURNS integer
    LANGUAGE sql WINDOW IMMUTABLE
    SET "TimeZone" TO 'utc'
    SET search_path TO public, pg_catalog
    AS $_$select $1 + $2;$_$;
    
ALTER FUNCTION public.add1(integer, integer) OWNER TO unit_test;

CREATE FUNCTION public.increment(i integer DEFAULT 0, j integer DEFAULT 0) RETURNS integer
    LANGUAGE plpgsql
    AS $$ BEGIN RETURN i + 1; END; $$;

ALTER FUNCTION public.increment(i integer, j integer) OWNER TO unit_test;

COMMENT ON FUNCTION public.increment(i integer, j integer) IS 'this is test function';

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE public.t1 (
    c1 integer NOT NULL,
    c2 text COLLATE pg_catalog."ru_RU.utf8" DEFAULT 'as'::text NOT NULL,
    c3 integer,
    CONSTRAINT c3_const CHECK ((c3 > 0)),
    CONSTRAINT t1_c2_check CHECK ((c2 <> ''::text)),
    CONSTRAINT t1_pkey PRIMARY KEY (c1)
) 
WITH (fillfactor='70', OIDS=true)
TABLESPACE pgcodekeeper_testing;

ALTER TABLE public.t1 OWNER TO unit_test;

COMMENT ON TABLE public.t1 IS 'This is test table';

CREATE TABLE public.t2 (
    c2 integer,
    CONSTRAINT t2_c2_constr FOREIGN KEY (c2) REFERENCES public.t1(c1)
);

ALTER TABLE public.t2 OWNER TO unit_test;

ALTER TABLE public.t2 ALTER COLUMN c2 SET STATISTICS 2;

CREATE TABLE public.t3 (
    c4 integer
)
INHERITS (public.t2)
WITH OIDS;

ALTER TABLE public.t3 OWNER TO unit_test;

SET default_tablespace = pgcodekeeper_testing;

SET default_with_oids = true;

CREATE TABLE public.t4 (
    c1 integer
)WITH OIDS TABLESPACE pgcodekeeper_testing;


ALTER TABLE public.t4 OWNER TO unit_test;

CREATE SEQUENCE public.seq1
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
    CYCLE;

ALTER TABLE public.seq1 OWNER TO unit_test;

ALTER SEQUENCE public.seq1 OWNED BY public.t1.c1;

CREATE SEQUENCE public.seq2
    START WITH -20
    INCREMENT BY -1
    NO MINVALUE
    MAXVALUE -1
    CACHE 1;


ALTER TABLE public.seq2 OWNER TO unit_test;

CREATE SEQUENCE public.seq3
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.seq3 OWNER TO unit_test;

COMMENT ON SEQUENCE public.seq1 IS 'this is test sequence';

CREATE VIEW public.v1 AS
 SELECT t1.c1 AS i
   FROM public.t1;

ALTER TABLE public.v1 OWNER TO unit_test;

COMMENT ON VIEW public.v1 IS 'this is test view';

REVOKE ALL(i) ON TABLE public.v1 FROM PUBLIC;
REVOKE ALL(i) ON TABLE public.v1 FROM unit_test;
GRANT ALL(i) ON TABLE public.v1 TO unit_test;

CREATE OR REPLACE VIEW public.v2 AS
    WITH _outer AS (
         WITH t3 AS (
                 SELECT t1.c1
                   FROM public.t1
                )
         SELECT t3.c1,
            t2.c2
           FROM t3,
            public.t2
        )
 SELECT _outer.c1
   FROM _outer;
   
ALTER TABLE public.v2 OWNER TO unit_test;

CREATE UNIQUE INDEX ind1 ON public.t1 USING btree (c2 COLLATE "default") TABLESPACE pgcodekeeper_testing;

COMMENT ON INDEX public.ind1 IS 'this is test index';

ALTER TABLE public.t1 CLUSTER ON ind1;

CREATE TRIGGER trig1 BEFORE UPDATE ON public.t1 FOR EACH ROW WHEN ((old.c1 IS DISTINCT FROM new.c1)) EXECUTE PROCEDURE public.trfunc();

COMMENT ON TRIGGER trig1 ON public.t1 IS 'this is test trigger';

CREATE TRIGGER trig2 BEFORE INSERT ON public.t1 FOR EACH ROW WHEN ((new.c1 = 0)) EXECUTE PROCEDURE public.trfunc();

CREATE TRIGGER trig3 BEFORE DELETE ON public.t1 FOR EACH ROW WHEN ((old.c1 = 0)) EXECUTE PROCEDURE public.trfunc();

CREATE TRIGGER trig4 BEFORE TRUNCATE ON public.t1 EXECUTE PROCEDURE public.trfunc();

CREATE TRIGGER trig5 AFTER UPDATE OF c1,c2 ON public.t1 FOR EACH ROW EXECUTE PROCEDURE public.trfunc();

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
