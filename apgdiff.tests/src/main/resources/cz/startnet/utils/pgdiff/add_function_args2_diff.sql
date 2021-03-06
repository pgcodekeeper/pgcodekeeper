SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.multiply_numbers(number1 integer, number2 integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	return number1 * number2;
end;
$$;

ALTER FUNCTION public.multiply_numbers(number1 integer, number2 integer) OWNER TO fordfrog;
