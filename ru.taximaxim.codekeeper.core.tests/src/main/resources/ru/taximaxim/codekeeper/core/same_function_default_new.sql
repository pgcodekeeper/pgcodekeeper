CREATE FUNCTION public.multiply_numbers(number1 integer = 2, number2 integer = 2) RETURNS integer
    AS $$
begin
	return number1 * number2;
end;
$$
    LANGUAGE plpgsql;