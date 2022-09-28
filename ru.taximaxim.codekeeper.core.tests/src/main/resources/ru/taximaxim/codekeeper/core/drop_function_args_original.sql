CREATE FUNCTION public.power_number("input" integer) RETURNS integer
    AS $$
begin
	return input * input;
end;
$$
    LANGUAGE plpgsql;