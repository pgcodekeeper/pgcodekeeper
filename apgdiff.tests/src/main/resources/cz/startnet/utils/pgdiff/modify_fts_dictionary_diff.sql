SET search_path = pg_catalog;

DROP TEXT SEARCH DICTIONARY public.first_dictionary;

CREATE TEXT SEARCH DICTIONARY public.third_dictionary (
	TEMPLATE = pg_catalog.snowball,
	language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.third_dictionary OWNER TO galiev_mr;

DROP TEXT SEARCH DICTIONARY public.second_dictionary;

CREATE TEXT SEARCH DICTIONARY public.second_dictionary (
	TEMPLATE = pg_catalog.simple,
	language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.second_dictionary OWNER TO galiev_mr;
