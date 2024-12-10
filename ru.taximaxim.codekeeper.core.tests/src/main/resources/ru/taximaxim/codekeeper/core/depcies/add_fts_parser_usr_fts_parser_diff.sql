SET search_path = pg_catalog;

-- DEPCY: This FUNCTION prsd_headline is a dependency of FTS_PARSER: public.fts_parser

CREATE OR REPLACE FUNCTION public.prsd_headline(internal, internal, tsquery) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS $$prsd_headline$$;

-- DEPCY: This FUNCTION prsd_lextype is a dependency of FTS_PARSER: public.fts_parser

CREATE OR REPLACE FUNCTION public.prsd_lextype(internal) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS $$prsd_lextype$$;

-- DEPCY: This FUNCTION prsd_end is a dependency of FTS_PARSER: public.fts_parser

CREATE OR REPLACE FUNCTION public.prsd_end(internal) RETURNS void
    LANGUAGE internal IMMUTABLE STRICT
    AS $$prsd_end$$;

-- DEPCY: This FUNCTION prsd_nexttoken is a dependency of FTS_PARSER: public.fts_parser

CREATE OR REPLACE FUNCTION public.prsd_nexttoken(internal, internal, internal) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS $$prsd_nexttoken$$;

-- DEPCY: This FUNCTION prsd_start is a dependency of FTS_PARSER: public.fts_parser

CREATE OR REPLACE FUNCTION public.prsd_start(internal, integer) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS $$prsd_start$$;

CREATE TEXT SEARCH PARSER public.fts_parser (
	START = public.prsd_start,
	GETTOKEN = public.prsd_nexttoken,
	END = public.prsd_end,
	HEADLINE = public.prsd_headline,
	LEXTYPES = public.prsd_lextype );