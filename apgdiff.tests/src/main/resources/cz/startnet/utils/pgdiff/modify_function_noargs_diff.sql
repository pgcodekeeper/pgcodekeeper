SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.return_one() RETURNS integer
    AS $$
begin
	return -1 + 2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.return_one() OWNER TO fordfrog;
