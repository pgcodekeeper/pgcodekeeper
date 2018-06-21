SET search_path = pg_catalog;

DROP FUNCTION public.multiply_numbers(number1 integer, number2 integer);

CREATE OR REPLACE FUNCTION public.multiply_numbers(number2 integer, number1 integer) RETURNS integer
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number2 integer, number1 integer) OWNER TO fordfrog;
