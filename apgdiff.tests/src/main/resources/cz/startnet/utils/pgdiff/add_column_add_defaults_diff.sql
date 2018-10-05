SET search_path = pg_catalog;

ALTER TABLE public.table1
	ADD COLUMN col2 integer;

ALTER TABLE ONLY public.table1
	ALTER COLUMN col2 SET NOT NULL;

ALTER TABLE public.table1
	ADD COLUMN col3 integer;

ALTER TABLE ONLY public.table1
	ALTER COLUMN col3 SET DEFAULT 5;

UPDATE ONLY public.table1
	SET col3 = DEFAULT WHERE col3 IS NULL;

ALTER TABLE ONLY public.table1
	ALTER COLUMN col3 SET NOT NULL;
