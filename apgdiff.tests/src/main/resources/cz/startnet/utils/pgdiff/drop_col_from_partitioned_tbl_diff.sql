SET search_path = pg_catalog;

ALTER TABLE public.measurement_year_month
	DROP COLUMN peaktemp;

-- DEPCY: This COLUMN depends on the COLUMN: public.measurement_year_month.unitsales

ALTER TABLE ONLY public.measurement_ym_y2017m01
	ALTER COLUMN unitsales DROP DEFAULT;

-- DEPCY: This COLUMN depends on the COLUMN: public.measurement_year_month.unitsales

ALTER TABLE ONLY public.measurement_ym_y2016m12
	ALTER COLUMN unitsales DROP DEFAULT;

-- DEPCY: This COLUMN depends on the COLUMN: public.measurement_year_month.unitsales

ALTER TABLE ONLY public.measurement_ym_y2016m11
	ALTER COLUMN unitsales DROP DEFAULT;

-- DEPCY: This COLUMN depends on the COLUMN: public.measurement_year_month.unitsales

ALTER TABLE ONLY public.measurement_ym_older
	ALTER COLUMN unitsales DROP DEFAULT;

ALTER TABLE public.measurement_year_month
	DROP COLUMN unitsales;
