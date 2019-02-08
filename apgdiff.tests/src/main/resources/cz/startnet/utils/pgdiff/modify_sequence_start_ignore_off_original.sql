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

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (field3);