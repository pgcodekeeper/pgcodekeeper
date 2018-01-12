SET TIMEZONE TO 'UTC';

-- DEPCY: This SCHEMA is a dependency of VIEW: v1

CREATE SCHEMA newschema;

ALTER SCHEMA newschema OWNER TO galiev_mr;

SET search_path = public, pg_catalog;

CREATE VIEW v1 AS
	SELECT t1.c1,
    t3.c2,
    t3.c3,
    t3.c4
   FROM t1, t3;

ALTER VIEW v1 OWNER TO galiev_mr;
