SET search_path = pg_catalog;

-- HIDDEN: Object public.v2 of type VIEW (action DROP)

-- HIDDEN: Object public.v1 of type VIEW (action DROP)

ALTER TABLE public.tbl
	ALTER COLUMN name TYPE integer USING name::integer; /* TYPE change - table: public.tbl original: text new: integer */

-- HIDDEN: Object public.v1 of type VIEW (action CREATE)

-- HIDDEN: Object public.v2 of type VIEW (action CREATE)

