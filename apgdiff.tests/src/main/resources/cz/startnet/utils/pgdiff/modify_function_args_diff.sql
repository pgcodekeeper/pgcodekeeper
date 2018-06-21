SET search_path = pg_catalog;

DROP FUNCTION public.power_number(input integer);

CREATE OR REPLACE FUNCTION public.power_number(number integer) RETURNS integer
    AS $$
begin
	return number * number;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.power_number(number integer) OWNER TO fordfrog;
