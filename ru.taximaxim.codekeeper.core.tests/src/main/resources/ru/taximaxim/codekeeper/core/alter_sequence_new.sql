 -- check unlogged sequence
CREATE TABLE public.test (
    c1 integer,
    c2 text
);

CREATE UNLOGGED SEQUENCE public.trigtest_i_seq1
    AS integer
    START WITH 7
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.trigtest_i_seq1 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq1
    OWNED BY public.test.c1;

CREATE TABLE public.test1 (
    c1 integer,
    c2 text
);

 -- check logged sequence
CREATE SEQUENCE public.trigtest_i_seq2
    AS integer
    START WITH 7
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.trigtest_i_seq2 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq2
    OWNED BY public.test1.c1;
    