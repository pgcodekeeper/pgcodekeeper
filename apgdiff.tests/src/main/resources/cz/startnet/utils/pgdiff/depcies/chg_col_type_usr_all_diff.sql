SET search_path = public, pg_catalog;

CREATE DOMAIN dom2 AS integer
	CONSTRAINT chechk1 CHECK ((VALUE > 0));

ALTER DOMAIN dom2 OWNER TO botov_av;

-- DEPCY: This VIEW depends on the COLUMN: t1.c1

DROP VIEW v1;

ALTER TABLE t1
	ALTER COLUMN c1 TYPE dom2 USING c1::dom2; /* TYPE change - table: t1 original: integer new: dom2 */

CREATE VIEW v1 AS
	SELECT t1.c1
   FROM t1;

ALTER VIEW v1 OWNER TO botov_av;
