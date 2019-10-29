CREATE TEXT SEARCH TEMPLATE public.fts_template (
    INIT = public.dsimple_init,
    LEXIZE = public.dsimple_lexize );