SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ALTER COLUMN field1 SET NOT NULL;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field2 SET DEFAULT 1000;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 SET DEFAULT 'word'::text;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field4 SET DEFAULT true;

ALTER TABLE public.testtable
	ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);
