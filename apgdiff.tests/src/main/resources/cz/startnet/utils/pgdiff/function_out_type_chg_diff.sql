SET search_path = public, pg_catalog;

DROP FUNCTION test(OUT p1 integer, OUT p2 text);

CREATE OR REPLACE FUNCTION test(OUT p1 bigint, OUT p2 text) RETURNS SETOF record
    LANGUAGE plpgsql
    AS $$begin null; end;$$;

ALTER FUNCTION test(OUT p1 bigint, OUT p2 text) OWNER TO botov_av;
