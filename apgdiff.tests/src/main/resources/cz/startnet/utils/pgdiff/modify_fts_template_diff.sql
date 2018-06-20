SET search_path = public, pg_catalog;

DROP TEXT SEARCH TEMPLATE first_template;

CREATE TEXT SEARCH TEMPLATE third_template (
	LEXIZE = dsnowball_lexize );

DROP TEXT SEARCH TEMPLATE second_template;

CREATE TEXT SEARCH TEMPLATE second_template (
	INIT = dsnowball_init,
	LEXIZE = dsnowball_lexize );
