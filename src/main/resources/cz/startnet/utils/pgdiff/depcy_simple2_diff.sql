SET search_path = s, pg_catalog;

-- DEPCY: This VIEW depends on the VIEW: v2

DROP VIEW v3;

SET search_path = public, pg_catalog;

DROP VIEW v2;

-- DEPCY: This VIEW is a dependency of VIEW: v3

CREATE VIEW v2 AS
	SELECT t1.id,
    'qwe' AS c1
   FROM t1;

ALTER VIEW v2 OWNER TO levsha_aa;

SET search_path = s, pg_catalog;

CREATE VIEW v3 AS
	SELECT v2.id
   FROM public.v2;

ALTER VIEW v3 OWNER TO levsha_aa;
