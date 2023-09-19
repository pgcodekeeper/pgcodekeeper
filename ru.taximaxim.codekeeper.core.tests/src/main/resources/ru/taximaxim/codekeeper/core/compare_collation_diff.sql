SET search_path = pg_catalog;

CREATE COLLATION public.test_collation1 (LOCALE = 'ru_RU.utf8');

CREATE COLLATION public.test_collation2 (LOCALE = 'ru_RU.utf8');

CREATE COLLATION public.test_collation3 (LOCALE = 'ru_RU.utf8');

CREATE COLLATION public.test_collation4 (LOCALE = 'ru_RU.utf8', DETERMINISTIC = FALSE);

CREATE COLLATION public.test_collation5 (LOCALE = 'ru_RU.utf8', PROVIDER = 'icu', DETERMINISTIC = FALSE);

CREATE COLLATION public.test_collation19 (LOCALE = 'ru_RU.utf8', PROVIDER = icu);

DROP COLLATION public.test_collation0;

DROP COLLATION public.test_collation8;

DROP COLLATION public.test_collation7;

DROP COLLATION public.test_collation10;

DROP COLLATION public.test_collation11;

DROP COLLATION public.test_collation12;

DROP COLLATION public.test_collation14;

ALTER COLLATION public.test_collation15 OWNER TO tavturinma37;

DROP COLLATION public.test_collation16;

DROP COLLATION public.test_collation17;

DROP COLLATION public.test_collation20;

CREATE COLLATION public.test_collation0 (LOCALE = 'ru_RU.utf8');

CREATE COLLATION public.test_collation8 (LOCALE = 'ru_RU.utf8', PROVIDER = 'icu', DETERMINISTIC = FALSE);

CREATE COLLATION public.test_collation7 (LOCALE = 'ru_RU.utf8', PROVIDER = 'icu');

CREATE COLLATION public.test_collation10 (LOCALE = 'ru_RU.utf8', DETERMINISTIC = FALSE);

CREATE COLLATION public.test_collation11 (LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8');

CREATE COLLATION public.test_collation12 (LC_COLLATE = 'sv_SE.utf8', LC_CTYPE = 'ru_RU.utf8');

CREATE COLLATION public.test_collation14 (LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8', PROVIDER = 'icu');

CREATE COLLATION public.test_collation16 (LOCALE = 'sv_SE.utf8', PROVIDER = 'icu');

CREATE COLLATION public.test_collation17 (LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8');

CREATE COLLATION public.test_collation20 (LOCALE = 'und', PROVIDER = icu, RULES = '&V<<w<<< W');