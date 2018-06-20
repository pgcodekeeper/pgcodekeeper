SET search_path = pg_catalog;

CREATE SEQUENCE public.testtable2_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.testtable2_id_seq OWNER TO fordfrog;

CREATE TABLE public.testtable2 (
	id integer DEFAULT nextval('testtable2_id_seq'::regclass) NOT NULL,
	col1 boolean NOT NULL
);

ALTER TABLE public.testtable2 OWNER TO fordfrog;

CREATE INDEX testindex ON public.testtable USING btree (field1);

ALTER TABLE public.testtable CLUSTER ON testindex;

CREATE INDEX testtable2_col1 ON public.testtable2 USING btree (col1);

ALTER TABLE public.testtable2 CLUSTER ON testtable2_col1;

ALTER SEQUENCE public.testtable2_id_seq
	OWNED BY public.testtable2.id;
