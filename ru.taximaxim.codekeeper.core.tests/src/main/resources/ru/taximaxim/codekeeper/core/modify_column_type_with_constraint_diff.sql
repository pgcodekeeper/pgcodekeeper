SET search_path = pg_catalog;

-- DEPCY: This CONSTRAINT products_unic_number_check depends on the COLUMN: public.products.unic_number

ALTER TABLE public.products
	DROP CONSTRAINT products_unic_number_check;

ALTER TABLE public.products
	ALTER COLUMN unic_number TYPE numeric USING unic_number::numeric; /* TYPE change - table: public.products original: integer new: numeric */

ALTER TABLE public.products
	ADD CONSTRAINT products_unic_number_check CHECK ((unic_number > 100));