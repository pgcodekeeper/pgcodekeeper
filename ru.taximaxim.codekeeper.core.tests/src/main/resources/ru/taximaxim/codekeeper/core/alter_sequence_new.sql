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

 -- 1) add OWNED BY
CREATE SEQUENCE public.person_age_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.person_age_seq OWNER TO khazieva_gr;

ALTER SEQUENCE public.person_age_seq
    OWNED BY public.person.age;
    
CREATE TABLE public.person (
    id bigint,
    age bigint DEFAULT nextval('public.person_age_seq'::regclass) NOT NULL
);

ALTER TABLE public.person OWNER TO khazieva_gr;

 -- 2) delete OWNED BY
CREATE SEQUENCE public.person_age_seq2
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 6;

ALTER SEQUENCE public.person_age_seq2 OWNER TO khazieva_gr;

CREATE TABLE public.person2 (
    id bigint,
    age bigint DEFAULT nextval('public.person_age_seq'::regclass) NOT NULL
);

ALTER TABLE public.person2 OWNER TO khazieva_gr;

 --3) added sequence with OWNED BY and option CACHE changed
CREATE SEQUENCE public.person_age_seq3
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 3;

ALTER SEQUENCE public.person_age_seq3 OWNER TO khazieva_gr;

ALTER SEQUENCE public.person_age_seq3
    OWNED BY public.person3.age;

CREATE TABLE public.person3 (
    id1 bigint,
    id bigint,
    age bigint DEFAULT nextval('public.person_age_seq3'::regclass) NOT NULL
);

ALTER TABLE public.person3 OWNER TO khazieva_gr;

 --4) create sequence with OWNED BY and option CACHE and INCREMENT changed
CREATE SEQUENCE public.person_age_seq5
    START WITH 1
    INCREMENT BY 2
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER SEQUENCE public.person_age_seq5 OWNER TO khazieva_gr;

ALTER SEQUENCE public.person_age_seq5
    OWNED BY public.person.age;

 --5) add neew sequence with OWNED BY
CREATE SEQUENCE public.person_age_seq4
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 5;

ALTER SEQUENCE public.person_age_seq4 OWNER TO khazieva_gr;

ALTER SEQUENCE public.person_age_seq4
    OWNED BY public.person.id;

