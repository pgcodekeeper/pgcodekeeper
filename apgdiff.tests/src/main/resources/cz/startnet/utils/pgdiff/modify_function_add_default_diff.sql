SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.multiply_numbers(number1 integer = 2, number2 integer = 2) RETURNS integer
    AS $$
begin
        return number1 * number2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number1 integer, number2 integer) OWNER TO fordfrog;
