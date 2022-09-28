CREATE SEQUENCE public.testseq
    AS smallint
    START WITH 15
    INCREMENT BY 2
    MAXVALUE 32767
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.testseq OWNER TO fordfrog;

CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);