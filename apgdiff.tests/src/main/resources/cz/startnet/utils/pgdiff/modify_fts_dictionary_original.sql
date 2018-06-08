CREATE TEXT SEARCH DICTIONARY public.first_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.first_dictionary OWNER TO galiev_mr;

CREATE TEXT SEARCH DICTIONARY public.second_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.second_dictionary OWNER TO galiev_mr;