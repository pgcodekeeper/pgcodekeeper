SET search_path = pg_catalog;

CREATE TYPE public.comp AS (
	f1 integer,
	f2 text,
	f3 bigint
);

ALTER TYPE public.comp OWNER TO fordfrog;

CREATE TABLE public.simple_table (
	c1 integer,
	c2 text,
	c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.simple_table OWNER TO fordfrog;

CREATE TABLE public.table_of_type OF public.comp (
	f1 WITH OPTIONS NOT NULL,
	f2 WITH OPTIONS DEFAULT 'text'::text
)
PARTITION BY LIST ("left"(lower(f2), 1));

ALTER TABLE public.table_of_type OWNER TO fordfrog;

ALTER TABLE public.table_of_type
	ADD CONSTRAINT tab_of_type_f3_check CHECK ((f3 > 0));
