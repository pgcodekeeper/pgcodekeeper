SET search_path = pg_catalog;

-- DEPCY: This SEQUENCE table2_col1_seq is a dependency of COLUMN: public.table2.col1

CREATE SEQUENCE public.table2_col1_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.table2_col1_seq OWNER TO fordfrog;

CREATE TABLE public.table2 (
	col1 integer DEFAULT nextval('public.table2_col1_seq'::regclass) NOT NULL
);

ALTER TABLE public.table2 OWNER TO fordfrog;

ALTER SEQUENCE public.table2_col1_seq
	OWNED BY public.table2.col1;