SET search_path = s, pg_catalog;

-- DEPCY: This view depends on the view we are about to drop: v2

DROP VIEW v3;

SET search_path = public, pg_catalog;

DROP VIEW v2;

SET search_path = s, pg_catalog;

-- DEPCY: dropping dependant object: column id of table t1 is altered (type changed)

DROP VIEW v1;

SET search_path = s, pg_catalog;

-- DEPCY: dropping dependant object: column id of table t1 is altered (type changed)

SET search_path = public, pg_catalog;

-- DEPCY: dropping dependant object: column id of table t1 is altered (type changed)

SET search_path = public, pg_catalog;

ALTER TABLE t1
	ALTER COLUMN id TYPE bigint /* TYPE change - table: t1 original: integer new: bigint */;

-- DEPCY: recreating dropped dependant object: column id of table t1 is altered (type changed)

CREATE VIEW v2 AS
	SELECT t1.id
   FROM t1;

ALTER VIEW v2 OWNER TO levsha_aa;

SET search_path = s, pg_catalog;

-- DEPCY: recreating dropped dependant object: column id of table t1 is altered (type changed)

CREATE VIEW v3 AS
	SELECT v2.id
   FROM public.v2;

ALTER VIEW v3 OWNER TO levsha_aa;

SET search_path = s, pg_catalog;

-- DEPCY: recreating dropped dependant object: column id of table t1 is altered (type changed)

CREATE VIEW v1 AS
	SELECT t1.id
   FROM public.t1;

ALTER VIEW v1 OWNER TO levsha_aa;

SET search_path = public, pg_catalog;

SET search_path = s, pg_catalog;

-- DEPCY: Following view depends on the altered view v2
