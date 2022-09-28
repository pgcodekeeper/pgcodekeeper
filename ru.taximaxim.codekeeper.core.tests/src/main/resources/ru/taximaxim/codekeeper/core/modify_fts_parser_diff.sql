SET search_path = pg_catalog;

DROP TEXT SEARCH PARSER public.first_parser;

CREATE TEXT SEARCH PARSER public.third_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	HEADLINE = prsd_headline,
	LEXTYPES = prsd_lextype );

DROP TEXT SEARCH PARSER public.second_parser;

CREATE TEXT SEARCH PARSER public.second_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	LEXTYPES = prsd_lextype );
