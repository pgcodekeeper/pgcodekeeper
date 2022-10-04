SET search_path = pg_catalog;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	ALTER MAPPING FOR file
	WITH english_stem, danish_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	DROP MAPPING FOR numhword;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	DROP MAPPING FOR version;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	ALTER MAPPING FOR url
	WITH danish_stem, english_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	ALTER MAPPING FOR int
	WITH english_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	ADD MAPPING FOR tag
	WITH english_stem, danish_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	ADD MAPPING FOR email
	WITH english_stem;
