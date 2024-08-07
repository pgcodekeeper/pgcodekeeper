CREATE TABLE public.test_1 (
    c1 integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
);

CREATE TABLE public.test_2 (
    "c / 2" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
);

CREATE TABLE public.test_3 (
    c1 integer NOT NULL GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME sss)
);

CREATE TABLE public.test_4 (
    c1 integer NOT NULL GENERATED ALWAYS AS IDENTITY (SEQUENCE NAME test_seq START WITH 2 INCREMENT BY 3 MINVALUE -4 MAXVALUE 5 CACHE 1 CYCLE)
);

CREATE UNLOGGED TABLE public.t1 (
	row_id bigint NOT NULL
);

ALTER TABLE public.t1 ALTER COLUMN row_id ADD GENERATED ALWAYS AS IDENTITY (
	SEQUENCE NAME t1_row_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1
);
ALTER SEQUENCE public.t1_row_id_seq SET UNLOGGED;

CREATE TABLE public.t2 (
	row_id bigint NOT NULL
);

ALTER TABLE public.t2 ALTER COLUMN row_id ADD GENERATED ALWAYS AS IDENTITY (
	SEQUENCE NAME t2_row_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1
);
ALTER SEQUENCE public.t2_row_id_seq SET LOGGED;


CREATE UNLOGGED TABLE public.t3 (
	row_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY
);