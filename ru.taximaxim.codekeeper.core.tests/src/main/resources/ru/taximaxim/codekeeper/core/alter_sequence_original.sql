 -- check unlogged sequence
CREATE TABLE public.test (
    c1 integer,
    c2 text
);

CREATE SEQUENCE public.trigtest_i_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.trigtest_i_seq1 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq1
    OWNED BY public.test.c1;
    
 -- check logged sequence
CREATE TABLE public.test1 (
    c1 integer,
    c2 text
);

CREATE UNLOGGED SEQUENCE public.trigtest_i_seq2
    AS integer
    START WITH 7
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.trigtest_i_seq2 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq2
    OWNED BY public.test1.c1;

 -- 1) create sequence without OWNED BY
CREATE SEQUENCE public.person_age_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.person_age_seq OWNER TO khazieva_gr;

 --2) create sequence with OWNED BY
CREATE SEQUENCE public.person_age_seq2
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 6;

ALTER SEQUENCE public.person_age_seq2 OWNER TO khazieva_gr;

ALTER SEQUENCE public.person_age_seq2
    OWNED BY public.person2.age;

CREATE TABLE public.person2 (
    id bigint,
    age bigint DEFAULT nextval('public.person_age_seq'::regclass) NOT NULL
);

ALTER TABLE public.person2 OWNER TO khazieva_gr;

 --3) create sequence without OWNED BY and option CACHE changed
CREATE SEQUENCE public.person_age_seq3
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.person_age_seq3 OWNER TO khazieva_gr;

CREATE TABLE public.person3 (
    id1 bigint,
    id bigint,
    age bigint DEFAULT nextval('public.person_age_seq3'::regclass) NOT NULL
);

ALTER TABLE public.person3 OWNER TO khazieva_gr;

 --4) create sequence with OWNED BY and option CACHE and INCREMENT changed
 CREATE SEQUENCE public.person_age_seq5
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 3;

ALTER SEQUENCE public.person_age_seq5 OWNER TO khazieva_gr;

ALTER SEQUENCE public.person_age_seq5
    OWNED BY public.person.age;
