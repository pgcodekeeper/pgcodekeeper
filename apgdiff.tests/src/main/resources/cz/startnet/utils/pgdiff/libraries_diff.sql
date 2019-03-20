SET search_path = pg_catalog;

ALTER TABLE public.test
	DROP CONSTRAINT text_check;

ALTER TABLE public.test
	ADD CONSTRAINT text_check CHECK ((length((text)::text) > 1));

