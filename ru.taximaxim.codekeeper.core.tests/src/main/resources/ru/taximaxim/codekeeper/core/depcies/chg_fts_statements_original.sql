CREATE TEXT SEARCH PARSER public.first_parser (
    START = prsd_start,
    GETTOKEN = prsd_nexttoken,
    END = prsd_end,
    HEADLINE = prsd_headline,
    LEXTYPES = prsd_lextype );

CREATE TEXT SEARCH TEMPLATE public.first_template (
    INIT = dsnowball_init,  
    LEXIZE = dsnowball_lexize );
    
CREATE TEXT SEARCH DICTIONARY public.first_dictionary (
    TEMPLATE = public.first_template,
    language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.first_dictionary OWNER TO galiev_mr;
    
CREATE TEXT SEARCH CONFIGURATION public.first_configuration (
    PARSER = public.first_parser );
    
ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR tag
    WITH public.first_dictionary, english_stem;
    
ALTER TEXT SEARCH CONFIGURATION public.first_configuration OWNER TO galiev_mr;
