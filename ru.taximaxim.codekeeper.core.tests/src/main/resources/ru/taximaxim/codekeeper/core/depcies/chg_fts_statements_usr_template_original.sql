CREATE TEXT SEARCH TEMPLATE public.first_template (
    INIT = dsnowball_init,  
    LEXIZE = dsnowball_lexize );