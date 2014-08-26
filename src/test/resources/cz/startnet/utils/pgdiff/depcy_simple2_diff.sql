SET search_path = s, pg_catalog;

-- DEPCY: This view depends on the view we are about to drop: v2

DROP VIEW v3;

SET search_path = public, pg_catalog;

DROP VIEW v2;

CREATE VIEW v2 AS
	SELECT t1.id,
    'qwe' AS c1
   FROM t1;

ALTER VIEW v2 OWNER TO levsha_aa;

SET search_path = s, pg_catalog;

-- DEPCY: Following view depends on the altered view v2

CREATE VIEW v3 AS
	SELECT v2.id
   FROM public.v2;

ALTER VIEW v3 OWNER TO levsha_aa;

SET search_path = s, pg_catalog;

SET search_path = public, pg_catalog;

SET search_path = s, pg_catalog;
