SET search_path = pg_catalog;

DROP FUNCTION public.multiply_numbers(number2 smallint, number1 smallint);

CREATE OR REPLACE FUNCTION public.multiply_numbers(number1 smallint, number2 smallint) RETURNS smallint
    LANGUAGE plpgsql
    AS $$
begin
        return number1 * number2;
end;
$$;

ALTER FUNCTION public.multiply_numbers(number1 smallint, number2 smallint) OWNER TO fordfrog;
