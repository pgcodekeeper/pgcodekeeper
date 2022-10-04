CREATE TEXT SEARCH TEMPLATE public.second_template (
    INIT = dsnowball_init,
    LEXIZE = dsnowball_lexize );
    
CREATE TEXT SEARCH TEMPLATE public.third_template (
    LEXIZE = dsnowball_lexize );
    