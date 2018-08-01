SET search_path = pg_catalog;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4 DROP DEFAULT;

-- DEPCY: This CONSTRAINT depends on the TYPE: public.testtype

ALTER TABLE public.testtable
	DROP CONSTRAINT testtable_pkey;

-- DEPCY: This COLUMN depends on the TYPE: public.testtype

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 DROP DEFAULT;

-- DEPCY: This COLUMN depends on the TYPE: public.testtype

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field2 DROP DEFAULT;

-- DEPCY: This COLUMN depends on the TYPE: public.testtype

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field1 DROP NOT NULL;

-- DEPCY: This TABLE depends on the TYPE: public.testtype

DROP TABLE public.testtable;

ALTER TYPE public.testtype
	ADD ATTRIBUTE field4new numeric, 
	DROP ATTRIBUTE field4;

-- DEPCY: This TABLE is a dependency of COLUMN: public.testtable.field4new

CREATE TABLE public.testtable OF public.testtype (
	field1 WITH OPTIONS NOT NULL,
	field2 WITH OPTIONS DEFAULT 1000,
	field3 WITH OPTIONS DEFAULT 'word'::text,
	field4new WITH OPTIONS DEFAULT 2000
);

ALTER TABLE public.testtable OWNER TO shamsutdinov_lr;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4new SET DEFAULT 2000;

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 SET DEFAULT 'word'::text;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field2 SET DEFAULT 1000;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field1 SET NOT NULL;
