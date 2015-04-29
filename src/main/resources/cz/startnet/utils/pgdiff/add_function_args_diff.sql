
CREATE OR REPLACE FUNCTION power_number("input" integer) RETURNS integer
    AS $$
begin
	return input * input;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION power_number("input" integer) OWNER TO fordfrog;
