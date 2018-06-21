SET search_path = public, pg_catalog;

DROP TEXT SEARCH CONFIGURATION first_configuration;

CREATE TEXT SEARCH CONFIGURATION third_configuration (
	PARSER = public.second_parser );

ALTER TEXT SEARCH CONFIGURATION third_configuration OWNER TO galiev_mr;

DROP TEXT SEARCH CONFIGURATION second_configuration;

CREATE TEXT SEARCH CONFIGURATION second_configuration (
	PARSER = public.first_parser );

ALTER TEXT SEARCH CONFIGURATION second_configuration OWNER TO galiev_mr;
