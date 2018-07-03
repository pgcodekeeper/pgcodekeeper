SET search_path = public, pg_catalog;

DROP TEXT SEARCH PARSER first_parser;

CREATE TEXT SEARCH PARSER third_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	HEADLINE = prsd_headline,
	LEXTYPES = prsd_lextype );

DROP TEXT SEARCH PARSER second_parser;

CREATE TEXT SEARCH PARSER second_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	LEXTYPES = prsd_lextype );
