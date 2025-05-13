SET search_path = pg_catalog;

-- DEPCY: This FTS_CONFIGURATION first_configuration depends on the FTS_DICTIONARY: public.first_dictionary

DROP TEXT SEARCH CONFIGURATION public.first_configuration;

DROP TEXT SEARCH DICTIONARY public.first_dictionary;

-- DEPCY: This FTS_TEMPLATE second_template is a dependency of FTS_CONFIGURATION: public.first_configuration

CREATE TEXT SEARCH TEMPLATE public.second_template (
	LEXIZE = dsnowball_lexize );

CREATE TEXT SEARCH DICTIONARY public.first_dictionary (
	TEMPLATE = public.second_template,
	language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.first_dictionary OWNER TO galiev_mr;

-- DEPCY: This FTS_PARSER first_parser depends on the FTS_CONFIGURATION: public.first_configuration

DROP TEXT SEARCH PARSER public.first_parser;

-- DEPCY: This FTS_PARSER first_parser is a dependency of FTS_CONFIGURATION: public.first_configuration

CREATE TEXT SEARCH PARSER public.first_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH CONFIGURATION public.first_configuration (
	PARSER = public.first_parser );

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
	ADD MAPPING FOR tag
	WITH public.first_dictionary;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration OWNER TO galiev_mr;