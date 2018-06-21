SET search_path = public, pg_catalog;

DROP TEXT SEARCH DICTIONARY first_dictionary;

CREATE TEXT SEARCH DICTIONARY third_dictionary (
	TEMPLATE = pg_catalog.snowball,
	language = 'english' );

ALTER TEXT SEARCH DICTIONARY third_dictionary OWNER TO galiev_mr;

DROP TEXT SEARCH DICTIONARY second_dictionary;

CREATE TEXT SEARCH DICTIONARY second_dictionary (
	TEMPLATE = pg_catalog.simple,
	language = 'english' );

ALTER TEXT SEARCH DICTIONARY second_dictionary OWNER TO galiev_mr;
