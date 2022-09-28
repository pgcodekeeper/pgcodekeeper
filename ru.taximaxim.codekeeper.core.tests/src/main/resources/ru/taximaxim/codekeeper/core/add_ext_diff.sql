SET search_path = pg_catalog;

DROP EXTENSION testext1;

CREATE SCHEMA other;

CREATE EXTENSION testext3 SCHEMA other;

DROP EXTENSION testext2;

COMMENT ON EXTENSION testext_comment IS 'new comment';

CREATE EXTENSION testext2 SCHEMA other;