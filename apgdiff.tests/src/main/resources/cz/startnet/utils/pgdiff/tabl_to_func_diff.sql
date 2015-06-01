-- DEPCY: This FUNCTION is a dependency of TABLE: t1

CREATE OR REPLACE FUNCTION testf() RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 0; end;$$;

ALTER FUNCTION testf() OWNER TO botov_av;

CREATE TABLE t1 (
	c1 integer DEFAULT testf()
);

ALTER TABLE t1 OWNER TO botov_av;