CREATE TEXT SEARCH DICTIONARY public.second_dictionary (
    TEMPLATE = pg_catalog.simple,
    language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.second_dictionary OWNER TO galiev_mr;

CREATE TEXT SEARCH DICTIONARY public.third_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.third_dictionary OWNER TO galiev_mr;