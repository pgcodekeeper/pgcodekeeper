SET search_path = pg_catalog;

REVOKE ALL ON TABLE public.test FROM PUBLIC;

GRANT SELECT ON TABLE public.test TO test_role;
GRANT INSERT ON TABLE public.test TO test_role;
GRANT UPDATE ON TABLE public.test TO test_role;

ALTER TABLE public.test
	DROP CONSTRAINT text_check;

ALTER TABLE public.test
	ADD CONSTRAINT text_check CHECK ((length((text)::text) > 1));
