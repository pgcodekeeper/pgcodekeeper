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
	ADD COLUMN field7 double precision DEFAULT 1 NOT NULL;