CREATE FUNCTION public.multiply_numbers(number2 integer, number1 integer) RETURNS integer
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;


ALTER FUNCTION public.multiply_numbers(number2 integer, number1 integer) OWNER TO fordfrog;

CREATE FUNCTION public.multiply_numbers(number1 smallint, number2 smallint) RETURNS smallint
    AS $$
begin
        return number1 * number2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number1 smallint, number2 smallint) OWNER TO fordfrog;