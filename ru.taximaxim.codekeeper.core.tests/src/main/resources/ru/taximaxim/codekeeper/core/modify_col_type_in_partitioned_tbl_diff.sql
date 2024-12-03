SET search_path = pg_catalog;

-- DEPCY: This COLUMN unitsales depends on the COLUMN: public.measurement_year_month.unitsales

ALTER TABLE ONLY public.measurement_ym_y2017m01
	ALTER COLUMN unitsales DROP DEFAULT;

ALTER TABLE ONLY public.measurement_ym_y2016m12
	ALTER COLUMN unitsales DROP DEFAULT;

ALTER TABLE ONLY public.measurement_ym_y2016m11
	ALTER COLUMN unitsales DROP DEFAULT;

ALTER TABLE ONLY public.measurement_ym_older
	ALTER COLUMN unitsales DROP DEFAULT;

ALTER TABLE ONLY public.measurement_year_month
	ALTER COLUMN unitsales DROP DEFAULT;

ALTER TABLE public.measurement_year_month
	ALTER COLUMN unitsales TYPE text USING unitsales::text; /* TYPE change - table: public.measurement_year_month original: integer new: text */

ALTER TABLE ONLY public.measurement_year_month
	ALTER COLUMN unitsales SET DEFAULT USER;

ALTER TABLE ONLY public.measurement_ym_y2017m01
	ALTER COLUMN unitsales SET DEFAULT USER;

ALTER TABLE ONLY public.measurement_ym_y2016m12
	ALTER COLUMN unitsales SET DEFAULT USER;

ALTER TABLE ONLY public.measurement_ym_y2016m11
	ALTER COLUMN unitsales SET DEFAULT USER;

ALTER TABLE ONLY public.measurement_ym_older
	ALTER COLUMN unitsales SET DEFAULT USER;