CREATE SEQUENCE public.testseq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.testseq OWNER TO fordfrog;

CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

CREATE TABLE public.test (
    c1 integer,
    c2 text
);

CREATE UNLOGGED SEQUENCE public.trigtest_i_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.trigtest_i_seq1 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq1
    OWNED BY public.test.c1;