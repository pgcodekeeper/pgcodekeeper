CREATE TEXT SEARCH PARSER public.parser (
    START = public.start, 
    GETTOKEN = public.get_token,
    END = public.end,
    LEXTYPES = public.lex
);

ALTER TEXT SEARCH PARSER public.parser SET SCHEMA private;

DROP TEXT SEARCH PARSER private.parser;