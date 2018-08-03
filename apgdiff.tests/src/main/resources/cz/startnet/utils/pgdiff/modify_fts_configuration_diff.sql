SET search_path = pg_catalog;

DROP TEXT SEARCH CONFIGURATION public.first_configuration;

CREATE TEXT SEARCH CONFIGURATION public.third_configuration (
	PARSER = public.second_parser );

ALTER TEXT SEARCH CONFIGURATION public.third_configuration OWNER TO galiev_mr;

DROP TEXT SEARCH CONFIGURATION public.second_configuration;

CREATE TEXT SEARCH CONFIGURATION public.second_configuration (
	PARSER = public.first_parser );

ALTER TEXT SEARCH CONFIGURATION public.second_configuration OWNER TO galiev_mr;
