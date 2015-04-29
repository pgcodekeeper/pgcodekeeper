SET search_path = s, pg_catalog;

-- DEPCY: This VIEW depends on the COLUMN: t1.id

DROP VIEW v1;

-- DEPCY: This VIEW depends on the COLUMN: t1.id

DROP VIEW v3;

SET search_path = public, pg_catalog;

-- DEPCY: This VIEW depends on the COLUMN: t1.id

DROP VIEW v2;

ALTER TABLE t1
	ALTER COLUMN id TYPE bigint; /* TYPE change - table: t1 original: integer new: bigint */

SET search_path = s, pg_catalog;

CREATE VIEW v1 AS
	SELECT t1.id
   FROM public.t1;

ALTER VIEW v1 OWNER TO levsha_aa;

SET search_path = public, pg_catalog;

-- DEPCY: This VIEW is a dependency of VIEW: v3

CREATE VIEW v2 AS
	SELECT t1.id
   FROM t1;

ALTER VIEW v2 OWNER TO levsha_aa;

SET search_path = s, pg_catalog;

CREATE VIEW v3 AS
	SELECT v2.id
   FROM public.v2;

ALTER VIEW v3 OWNER TO levsha_aa;
