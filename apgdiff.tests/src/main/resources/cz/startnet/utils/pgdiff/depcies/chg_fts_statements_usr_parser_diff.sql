SET search_path = public, pg_catalog;

-- DEPCY: This FTS_CONFIGURATION depends on the FTS_PARSER: first_parser

DROP TEXT SEARCH CONFIGURATION first_configuration;

DROP TEXT SEARCH PARSER first_parser;

-- DEPCY: This FTS_TEMPLATE is a dependency of FTS_CONFIGURATION: first_configuration

CREATE TEXT SEARCH TEMPLATE second_template (
	LEXIZE = dsnowball_lexize );

DROP TEXT SEARCH DICTIONARY first_dictionary;

-- DEPCY: This FTS_DICTIONARY is a dependency of FTS_CONFIGURATION: first_configuration

CREATE TEXT SEARCH DICTIONARY first_dictionary (
	TEMPLATE = public.second_template,
	language = 'english' );

ALTER TEXT SEARCH DICTIONARY first_dictionary OWNER TO galiev_mr;

-- DEPCY: This FTS_PARSER is a dependency of FTS_CONFIGURATION: first_configuration

CREATE TEXT SEARCH PARSER first_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH CONFIGURATION first_configuration (
	PARSER = public.first_parser );

ALTER TEXT SEARCH CONFIGURATION first_configuration
	ADD MAPPING FOR tag
	WITH public.first_dictionary;

ALTER TEXT SEARCH CONFIGURATION first_configuration OWNER TO galiev_mr;
