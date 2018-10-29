SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.power_number(input integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	return input * input;
end;
$$;

ALTER FUNCTION public.power_number(input integer) OWNER TO fordfrog;
