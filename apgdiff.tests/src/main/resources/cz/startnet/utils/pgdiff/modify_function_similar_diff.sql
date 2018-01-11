SET search_path = public, pg_catalog;

DROP FUNCTION multiply_numbers(number2 smallint, number1 smallint);

CREATE OR REPLACE FUNCTION multiply_numbers(number1 smallint, number2 smallint) RETURNS smallint
    AS $$
begin
        return number1 * number2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION multiply_numbers(number1 smallint, number2 smallint) OWNER TO fordfrog;
