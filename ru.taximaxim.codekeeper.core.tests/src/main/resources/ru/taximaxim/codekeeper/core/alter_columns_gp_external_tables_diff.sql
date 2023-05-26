SET search_path = pg_catalog;

ALTER EXTERNAL TABLE public.ext_customer
	DROP COLUMN name;

ALTER EXTERNAL TABLE public.ext_customer
	ADD COLUMN col3 text;

ALTER EXTERNAL TABLE public.ext_customer
	ALTER COLUMN sponsor TYPE integer; /* TYPE change - table: public.ext_customer original: text new: integer */
