SET search_path = public, pg_catalog;

DROP FUNCTION multiply_numbers(number1 integer, number2 integer);

CREATE OR REPLACE FUNCTION multiply_numbers(number2 integer, number1 integer) RETURNS integer
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION multiply_numbers(number2 integer, number1 integer) OWNER TO fordfrog;
