SET search_path = pg_catalog;

ALTER TABLE ONLY public.test_2
	ALTER COLUMN c1 DROP DEFAULT;

ALTER TABLE ONLY public.test_1
	ALTER COLUMN c1 DROP DEFAULT;

ALTER TABLE public.test_1
	ALTER COLUMN c1 TYPE text USING c1::text; /* TYPE change - table: public.test_1 original: integer new: text */

ALTER TABLE ONLY public.test_1
	ALTER COLUMN c1 SET DEFAULT '12';

ALTER TABLE ONLY public.test_2
	ALTER COLUMN c1 SET DEFAULT '21';