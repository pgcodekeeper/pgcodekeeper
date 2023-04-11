SET search_path = pg_catalog;

ALTER TYPE public.typ_composite
	ADD ATTRIBUTE added_attr text COLLATE pg_catalog."en_GB",
	ADD ATTRIBUTE "Col_Name" text COLLATE pg_catalog."en_GB";
