SET search_path = public, pg_catalog;

ALTER TEXT SEARCH CONFIGURATION first_configuration
	ALTER MAPPING FOR tag
	WITH public.first_dictionary;
