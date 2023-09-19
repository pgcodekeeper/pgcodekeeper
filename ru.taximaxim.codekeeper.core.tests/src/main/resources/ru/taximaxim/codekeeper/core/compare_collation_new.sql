--LOCALE--
CREATE COLLATION public.test_collation0 (LOCALE = 'ru_RU.utf8');
CREATE COLLATION public.test_collation8 (PROVIDER = 'icu', LOCALE = 'ru_RU.utf8', VERSION = '153.14.36.8', DETERMINISTIC = false);
CREATE COLLATION public.test_collation18 (PROVIDER = 'icu', LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'ru_RU.utf8', VERSION = '153.14.36.8');
--absent in original--
CREATE COLLATION public.test_collation1 (LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'ru_RU.utf8');
CREATE COLLATION public.test_collation2 (LOCALE = 'ru_RU.utf8');
CREATE COLLATION public.test_collation3 (LOCALE = 'ru_RU.utf8', VERSION = '153.14.36.8');
CREATE COLLATION public.test_collation4 (LOCALE = 'ru_RU.utf8', DETERMINISTIC = false);
CREATE COLLATION public.test_collation5 (PROVIDER = 'icu', LOCALE = 'ru_RU.utf8', VERSION = '153.14.36.8', DETERMINISTIC = false);
--PROVIDER--
CREATE COLLATION public.test_collation7 (PROVIDER = 'icu', LOCALE = 'ru_RU.utf8');
--VERSION--
CREATE COLLATION public.test_collation9 (LOCALE = 'ru_RU.utf8', VERSION = '153.14.36.8');
--DETERMINISTIC--
CREATE COLLATION public.test_collation10 (LOCALE = 'ru_RU.utf8', DETERMINISTIC = false);
--LC_COLLATE LC_CTYPE--
CREATE COLLATION public.test_collation11 (LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8');
CREATE COLLATION public.test_collation12 (LC_COLLATE = 'sv_SE.utf8', LC_CTYPE = 'ru_RU.utf8');
--equal--
CREATE COLLATION public.test_collation13 (PROVIDER = 'icu', LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8', VERSION = '153.14.36.8', DETERMINISTIC = false);
--LOCALE+ LC_COLLATE LC_COLLATE PROVIDER--
CREATE COLLATION public.test_collation14 (PROVIDER = 'icu', LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8');
--OWNER--
CREATE COLLATION public.test_collation15 (LOCALE = 'sv_SE.utf8');
ALTER COLLATION public.test_collation15 OWNER TO TavturinMA37;

CREATE COLLATION public.test_collation16 (PROVIDER = 'icu', LC_COLLATE = 'sv_SE.utf8', LC_CTYPE = 'sv_SE.utf8', VERSION = '153.14.36.8', DETERMINISTIC = true);
--LC_CTYPE--
CREATE COLLATION public.test_collation17 (LC_COLLATE = 'ru_RU.utf8', LC_CTYPE = 'sv_SE.utf8');
--alternative argument input via body.identifier --
CREATE COLLATION public.test_collation19 (LOCALE = 'ru_RU.utf8',PROVIDER = icu);
--LC_RULES--
CREATE COLLATION public.test_collation20 (provider = icu, locale = 'und', rules = '&V<<w<<< W');