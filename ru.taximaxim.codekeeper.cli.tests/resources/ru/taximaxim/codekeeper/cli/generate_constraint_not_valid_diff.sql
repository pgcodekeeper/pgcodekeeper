SET search_path = pg_catalog;

CREATE TABLE public.table1 (
	id text
);

CREATE TABLE public.table2 (
	id text
);

CREATE TABLE public.table3 (
	id text
);

CREATE TABLE public.table4 (
	id text
);

CREATE TABLE public.table5 PARTITION OF public.rrr (
	id WITH OPTIONS
)
DEFAULT;

ALTER TABLE public.table1
	ADD CONSTRAINT costr CHECK (id > 0) NOT VALID;

ALTER TABLE public.table1 VALIDATE CONSTRAINT costr;

ALTER TABLE public.table2
	ADD CONSTRAINT costr UNIQUE (id);

ALTER TABLE public.table3
	ADD CONSTRAINT costr FOREIGN KEY (id) REFERENCES public.table2 NOT VALID;

ALTER TABLE public.table3 VALIDATE CONSTRAINT costr;

ALTER TABLE public.table4
	ADD CONSTRAINT costr PRIMARY KEY (id);

ALTER TABLE public.table5
	ADD CONSTRAINT costr CHECK (id > 0);
