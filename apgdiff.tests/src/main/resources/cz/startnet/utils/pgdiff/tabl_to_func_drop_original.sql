CREATE SCHEMA defval;

ALTER SCHEMA defval OWNER TO levsha_aa;

CREATE OR REPLACE FUNCTION defval.f() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 4; end;$$;

ALTER FUNCTION defval.f() OWNER TO levsha_aa;

CREATE TABLE defval.t1 (
  c1 text DEFAULT defval.f()
);

ALTER TABLE defval.t1 OWNER TO levsha_aa;

