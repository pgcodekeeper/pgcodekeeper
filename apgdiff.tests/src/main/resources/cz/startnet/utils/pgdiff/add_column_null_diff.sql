SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD COLUMN field5 boolean;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field5 SET DEFAULT false;

ALTER TABLE public.testtable
	ADD COLUMN field6 integer;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field6 SET DEFAULT 0;

ALTER TABLE public.testtable
	ADD COLUMN field7 double precision;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field7 SET DEFAULT 1;

UPDATE ONLY public.testtable
	SET field7 = DEFAULT WHERE field7 IS NULL;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field7 SET NOT NULL;
