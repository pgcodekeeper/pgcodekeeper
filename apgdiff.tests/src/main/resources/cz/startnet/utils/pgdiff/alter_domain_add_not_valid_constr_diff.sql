SET search_path = pg_catalog;

ALTER DOMAIN public.dom5
	ADD CONSTRAINT dom5_check2 CHECK ((VALUE <> 1)) NOT VALID;
