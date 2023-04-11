SET search_path = pg_catalog;

ALTER TYPE public.typ_composite
	DROP ATTRIBUTE added_attr,
	DROP ATTRIBUTE "Col_Name";
