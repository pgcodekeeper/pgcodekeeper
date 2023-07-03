SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.return_one() RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	return -1 + 2;
end;
$$;
