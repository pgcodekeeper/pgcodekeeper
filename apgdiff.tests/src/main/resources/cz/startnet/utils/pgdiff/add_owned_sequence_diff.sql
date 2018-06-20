SET search_path = pg_catalog;

CREATE SEQUENCE public.table2_col1_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.table2_col1_seq OWNER TO fordfrog;

CREATE TABLE public.table2 (
	col1 integer DEFAULT nextval('table2_col1_seq'::regclass) NOT NULL
);

ALTER TABLE public.table2 OWNER TO fordfrog;

ALTER SEQUENCE public.table2_col1_seq
	OWNED BY public.table2.col1;
