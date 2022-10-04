SET search_path = pg_catalog;

ALTER TABLE public.people
	ADD COLUMN height_in numeric GENERATED ALWAYS AS (height_cm / 2.54) STORED;
