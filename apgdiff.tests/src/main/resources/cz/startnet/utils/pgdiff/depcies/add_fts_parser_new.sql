SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.prsd_headline(internal, internal, tsquery) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS 'prsd_headline';

CREATE OR REPLACE FUNCTION public.prsd_lextype(internal) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS 'prsd_lextype';

CREATE OR REPLACE FUNCTION public.prsd_end(internal) RETURNS void
    LANGUAGE internal IMMUTABLE STRICT
    AS 'prsd_end';

CREATE OR REPLACE FUNCTION public.prsd_nexttoken(internal, internal, internal) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS 'prsd_nexttoken';

CREATE OR REPLACE FUNCTION public.prsd_start(internal, integer) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS 'prsd_start';

CREATE TEXT SEARCH PARSER public.fts_parser (
    START = public.prsd_start,
    GETTOKEN = public.prsd_nexttoken,
    END = public.prsd_end,
    HEADLINE = public.prsd_headline,
    LEXTYPES = public.prsd_lextype );