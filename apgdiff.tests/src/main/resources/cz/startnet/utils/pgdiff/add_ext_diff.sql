SET search_path = pg_catalog;

DROP EXTENSION testext1;

CREATE SCHEMA other;

CREATE EXTENSION testext3 SCHEMA other;

ALTER EXTENSION testext2 SET SCHEMA other;

COMMENT ON EXTENSION testext_comment IS 'new comment';
