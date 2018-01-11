SET search_path = public, pg_catalog;

CREATE OR REPLACE FUNCTION return_one() RETURNS integer
    AS $$
begin
	return -1 + 2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION return_one() OWNER TO fordfrog;
