CREATE OR REPLACE FUNCTION testf() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;

ALTER FUNCTION testf() OWNER TO botov_av;

ALTER TABLE t1
	ALTER COLUMN c1 SET DEFAULT testf();