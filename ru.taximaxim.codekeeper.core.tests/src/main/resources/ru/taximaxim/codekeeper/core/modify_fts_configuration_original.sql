CREATE TEXT SEARCH PARSER public.first_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH PARSER public.second_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH CONFIGURATION public.first_configuration (
    PARSER = public.first_parser );

ALTER TEXT SEARCH CONFIGURATION public.first_configuration OWNER TO galiev_mr;

CREATE TEXT SEARCH CONFIGURATION public.second_configuration (
    PARSER = public.second_parser );

ALTER TEXT SEARCH CONFIGURATION public.second_configuration OWNER TO galiev_mr;
