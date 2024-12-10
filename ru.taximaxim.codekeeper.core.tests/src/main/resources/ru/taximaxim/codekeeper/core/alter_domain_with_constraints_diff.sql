SET search_path = pg_catalog;

ALTER DOMAIN public.dom
	DROP CONSTRAINT dom_check1;

ALTER DOMAIN public.dom
	ADD CONSTRAINT dom_check1 CHECK ((VALUE <> -1));

ALTER DOMAIN public.dom
	ADD CONSTRAINT dom_check2 CHECK ((VALUE < 5));

ALTER DOMAIN public.dom2
	DROP CONSTRAINT dom2_check1;

ALTER DOMAIN public.dom2
	ADD CONSTRAINT dom2_check1 CHECK ((VALUE > 2));

COMMENT ON CONSTRAINT dom2_check1 ON DOMAIN public.dom2 IS 'dom2 comment';

ALTER DOMAIN public.dom2
	ADD CONSTRAINT dom2_check2 CHECK ((VALUE > 6));

COMMENT ON CONSTRAINT dom3_check1 ON DOMAIN public.dom3 IS NULL;

ALTER DOMAIN public.dom3
	ADD CONSTRAINT dom3_check3 CHECK ((VALUE > -5));