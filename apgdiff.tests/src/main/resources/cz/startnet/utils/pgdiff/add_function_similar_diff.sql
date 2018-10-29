SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) RETURNS smallint
    LANGUAGE plpgsql
    AS $$
begin
        return number2 * number1;
end;
$$;

ALTER FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) OWNER TO fordfrog;
