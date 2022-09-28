CREATE TEXT SEARCH PARSER public.first_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );