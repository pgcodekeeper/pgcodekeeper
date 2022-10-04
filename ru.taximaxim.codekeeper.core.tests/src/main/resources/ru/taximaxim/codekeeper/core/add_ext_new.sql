CREATE SCHEMA other;

CREATE EXTENSION testext2 SCHEMA other;

CREATE EXTENSION testext3 WITH SCHEMA other VERSION '2';

CREATE EXTENSION testext_comment;

COMMENT ON EXTENSION testext_comment IS 'new comment';