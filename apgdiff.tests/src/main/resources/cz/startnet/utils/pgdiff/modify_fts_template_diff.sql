SET search_path = pg_catalog;

DROP TEXT SEARCH TEMPLATE public.first_template;

CREATE TEXT SEARCH TEMPLATE public.third_template (
	LEXIZE = dsnowball_lexize );

DROP TEXT SEARCH TEMPLATE public.second_template;

CREATE TEXT SEARCH TEMPLATE public.second_template (
	INIT = dsnowball_init,
	LEXIZE = dsnowball_lexize );
