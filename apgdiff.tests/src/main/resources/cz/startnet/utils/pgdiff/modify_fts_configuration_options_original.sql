CREATE TEXT SEARCH PARSER public.first_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH CONFIGURATION public.first_configuration (
    PARSER = public.first_parser );
    
ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR file
    WITH danish_stem, english_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR numhword
    WITH danish_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR version
    WITH english_stem, danish_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR url
    WITH danish_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR int
    WITH english_stem, danish_stem;

ALTER TEXT SEARCH CONFIGURATION public.first_configuration OWNER TO galiev_mr;
