SET search_path = pg_catalog;

UPDATE ONLY public.testtable
	SET field3 = DEFAULT WHERE field3 IS NULL;

ALTER TABLE ONLY public.testtable
	ALTER COLUMN field3 SET NOT NULL;
