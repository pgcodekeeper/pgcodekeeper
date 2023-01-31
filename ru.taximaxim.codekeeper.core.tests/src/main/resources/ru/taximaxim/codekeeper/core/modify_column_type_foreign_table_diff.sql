SET search_path = pg_catalog;

ALTER FOREIGN TABLE public.t1
	ALTER COLUMN c3 TYPE bigint; /* TYPE change - table: public.t1 original: integer new: bigint */
