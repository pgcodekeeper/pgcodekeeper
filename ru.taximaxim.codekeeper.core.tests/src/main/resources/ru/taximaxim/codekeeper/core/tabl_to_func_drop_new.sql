CREATE SCHEMA defval;

ALTER SCHEMA defval OWNER TO levsha_aa;

CREATE TABLE defval.t1 (
  c2 integer,
  c1 text DEFAULT USER
);

ALTER TABLE defval.t1 OWNER TO levsha_aa;
