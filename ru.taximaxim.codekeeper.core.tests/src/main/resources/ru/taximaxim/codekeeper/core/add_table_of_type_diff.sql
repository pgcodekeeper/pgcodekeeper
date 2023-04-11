SET search_path = pg_catalog;

CREATE TYPE public.testtype AS (
	field1 text,
	field2 numeric,
	field3 character(1),
	"Field4" boolean
);

ALTER TYPE public.testtype OWNER TO shamsutdinov_lr;

CREATE TABLE public.testtable OF public.testtype (
	field1 WITH OPTIONS NOT NULL,
	field2 WITH OPTIONS DEFAULT 1000,
	field3 WITH OPTIONS DEFAULT 'y'::bpchar,
	"Field4" WITH OPTIONS DEFAULT true
);

ALTER TABLE public.testtable OWNER TO shamsutdinov_lr;

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);
