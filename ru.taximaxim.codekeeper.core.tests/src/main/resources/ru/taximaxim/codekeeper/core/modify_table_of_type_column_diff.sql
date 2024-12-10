SET search_path = pg_catalog;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4 DROP DEFAULT;

-- DEPCY: This CONSTRAINT testtable_pkey depends on the TYPE: public.testtype

ALTER TABLE public.testtable
	DROP CONSTRAINT testtable_pkey;

-- DEPCY: This COLUMN field3 depends on the TYPE: public.testtype

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 DROP DEFAULT;

-- DEPCY: This COLUMN field2 depends on the TYPE: public.testtype

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field2 DROP DEFAULT;

-- DEPCY: This COLUMN field1 depends on the TYPE: public.testtype

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field1 DROP NOT NULL;

-- DEPCY: This TABLE testtable depends on the TYPE: public.testtype

DROP TABLE public.testtable;

ALTER TYPE public.testtype
	ADD ATTRIBUTE field4new numeric,
	DROP ATTRIBUTE field4;

CREATE TABLE public.testtable OF public.testtype (
	field1 WITH OPTIONS NOT NULL,
	field2 WITH OPTIONS DEFAULT 1000,
	field3 WITH OPTIONS DEFAULT 'word'::text,
	field4new WITH OPTIONS DEFAULT 2000
);

ALTER TABLE public.testtable OWNER TO shamsutdinov_lr;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 SET DEFAULT 'word'::text;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field2 SET DEFAULT 1000;

ALTER TABLE public.testtable
	ALTER COLUMN field1 SET NOT NULL;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4new SET DEFAULT 2000;

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);