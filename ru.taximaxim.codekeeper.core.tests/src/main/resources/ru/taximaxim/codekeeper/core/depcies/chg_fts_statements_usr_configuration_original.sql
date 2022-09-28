CREATE TEXT SEARCH CONFIGURATION public.first_configuration (
    PARSER = public.first_parser );
    
ALTER TEXT SEARCH CONFIGURATION public.first_configuration
    ADD MAPPING FOR tag
    WITH public.first_dictionary, english_stem;
    
ALTER TEXT SEARCH CONFIGURATION public.first_configuration OWNER TO galiev_mr;
