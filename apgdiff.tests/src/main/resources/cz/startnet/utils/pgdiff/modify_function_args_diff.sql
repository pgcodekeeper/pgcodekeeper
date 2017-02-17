DROP FUNCTION power_number(input integer);

CREATE OR REPLACE FUNCTION power_number(number integer) RETURNS integer
    AS $$
begin
	return number * number;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION power_number(number integer) OWNER TO fordfrog;
