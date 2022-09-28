SET search_path = pg_catalog;

ALTER TABLE ONLY public.people
	DROP COLUMN height_in;

ALTER TABLE public.people
	ADD COLUMN height_in numeric GENERATED ALWAYS AS (height_cm / 4.32) STORED;
