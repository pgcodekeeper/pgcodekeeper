CREATE FUNCTION public.power_number(number integer) RETURNS integer
    AS $$
begin
	return number * number;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.power_number(number integer) OWNER TO fordfrog;