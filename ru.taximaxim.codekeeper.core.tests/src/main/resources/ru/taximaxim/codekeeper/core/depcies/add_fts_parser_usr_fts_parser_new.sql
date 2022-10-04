CREATE TEXT SEARCH PARSER public.fts_parser (
    START = public.prsd_start,
    GETTOKEN = public.prsd_nexttoken,
    END = public.prsd_end,
    HEADLINE = public.prsd_headline,
    LEXTYPES = public.prsd_lextype );