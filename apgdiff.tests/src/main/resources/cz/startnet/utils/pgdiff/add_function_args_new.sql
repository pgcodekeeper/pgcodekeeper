CREATE FUNCTION public.power_number("input" integer) RETURNS integer
    AS $$
begin
	return input * input;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.power_number("input" integer) OWNER TO fordfrog;