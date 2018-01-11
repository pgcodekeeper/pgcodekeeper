SET search_path = public, pg_catalog;

ALTER TABLE ONLY testtable
	ALTER COLUMN field1 SET NOT NULL;

ALTER TABLE ONLY testtable
	ALTER COLUMN field2 SET DEFAULT 1000;

ALTER TABLE ONLY testtable
	ALTER COLUMN field3 SET DEFAULT 'word'::text;

ALTER TABLE ONLY testtable
	ALTER COLUMN field4 SET DEFAULT true;

ALTER TABLE testtable
	ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);
