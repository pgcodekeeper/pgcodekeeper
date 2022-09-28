CREATE TEXT SEARCH DICTIONARY public.first_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'russian', 
    stopwords = 'myrussian');

ALTER TEXT SEARCH DICTIONARY public.first_dictionary OWNER TO galiev_mr;

CREATE TEXT SEARCH DICTIONARY public.second_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'english' );

ALTER TEXT SEARCH DICTIONARY public.second_dictionary OWNER TO galiev_mr;

CREATE TEXT SEARCH DICTIONARY public.third_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'russian');

ALTER TEXT SEARCH DICTIONARY public.third_dictionary OWNER TO galiev_mr;

CREATE TEXT SEARCH DICTIONARY public.fourth_dictionary (
    TEMPLATE = pg_catalog.snowball,
    language = 'english');

ALTER TEXT SEARCH DICTIONARY public.fourth_dictionary OWNER TO galiev_mr;