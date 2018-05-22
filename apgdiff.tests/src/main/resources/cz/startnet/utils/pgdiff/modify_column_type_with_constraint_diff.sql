SET search_path = public, pg_catalog;

-- DEPCY: This CONSTRAINT depends on the COLUMN: products.unic_number

ALTER TABLE products
	DROP CONSTRAINT products_unic_number_check;

ALTER TABLE products
	ALTER COLUMN unic_number TYPE numeric USING unic_number::numeric; /* TYPE change - table: products original: integer new: numeric */

ALTER TABLE products
	ADD CONSTRAINT products_unic_number_check CHECK ((unic_number > 100));
