SET search_path = pg_catalog;

-- HIDDEN: Object public.v2 of type VIEW (action: DROP, reason: cannot change unselected objects in selected-only mode)

-- HIDDEN: Object public.v1 of type VIEW (action: DROP, reason: cannot change unselected objects in selected-only mode)

ALTER TABLE public.tbl
	ALTER COLUMN name TYPE integer USING name::integer; /* TYPE change - table: public.tbl original: text new: integer */

-- HIDDEN: Object public.v1 of type VIEW (action: CREATE, reason: cannot change unselected objects in selected-only mode)

-- HIDDEN: Object public.v2 of type VIEW (action: CREATE, reason: cannot change unselected objects in selected-only mode)
