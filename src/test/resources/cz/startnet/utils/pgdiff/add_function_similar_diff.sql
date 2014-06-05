
CREATE OR REPLACE FUNCTION multiply_numbers(number2 smallint, number1 smallint) RETURNS smallint
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION multiply_numbers(smallint,smallint) OWNER TO fordfrog;
