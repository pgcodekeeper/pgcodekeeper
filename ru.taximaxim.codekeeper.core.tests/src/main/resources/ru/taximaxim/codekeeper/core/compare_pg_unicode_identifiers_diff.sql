SET search_path = pg_catalog;

ALTER TABLE ONLY public.test
	DROP COLUMN data;

ALTER TABLE public.test
	ADD COLUMN U&"d\0061t\+000061" integer;