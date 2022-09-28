CREATE FUNCTION public.multiply_numbers(number2 integer, number1 integer) RETURNS integer
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;


ALTER FUNCTION public.multiply_numbers(number2 integer, number1 integer) OWNER TO fordfrog;

CREATE FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) RETURNS smallint
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) OWNER TO fordfrog;