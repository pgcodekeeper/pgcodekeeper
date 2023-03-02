SET search_path = pg_catalog;

CREATE TABLE public.person (
	id bigint,
	age bigint DEFAULT nextval('public.person_age_seq'::regclass) NOT NULL
);

ALTER TABLE public.person OWNER TO khazieva_gr;

CREATE SEQUENCE public.person_age_seq4
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 5;

ALTER SEQUENCE public.person_age_seq4 OWNER TO khazieva_gr;

ALTER SEQUENCE public.trigtest_i_seq1
	START WITH 7;

ALTER SEQUENCE public.trigtest_i_seq1 SET UNLOGGED;

ALTER SEQUENCE public.trigtest_i_seq2 SET LOGGED;

ALTER SEQUENCE public.person_age_seq2
	OWNED BY NONE;

ALTER SEQUENCE public.person_age_seq3
	CACHE 3
	OWNED BY public.person3.age;

ALTER SEQUENCE public.person_age_seq5
	INCREMENT BY 2
	CACHE 1;

ALTER SEQUENCE public.person_age_seq4
	OWNED BY public.person.id;

ALTER SEQUENCE public.person_age_seq
	OWNED BY public.person.age;

ALTER SEQUENCE public.person_age_seq3
	OWNED BY public.person3.age;