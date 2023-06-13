CREATE FUNCTION public.power_number("input" integer) RETURNS integer
    AS $$
begin
	return input * input;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.power_number("input" integer) OWNER TO fordfrog;

CREATE FUNCTION public.multiply_numbers(number1 integer, number2 integer) RETURNS integer
    AS $$
begin
	return number1 * number2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number1 integer, number2 integer) OWNER TO fordfrog;

CREATE FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) RETURNS smallint
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) OWNER TO fordfrog;

CREATE FUNCTION public.return_one() RETURNS integer
    AS $$
begin
	return 1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.return_one() OWNER TO fordfrog;

CREATE FUNCTION public.tr_func() RETURNS integer
    LANGUAGE sql TRANSFORM FOR TYPE integer
    AS $$ select 1; $$;

CREATE OR REPLACE FUNCTION public.w_func(val anyelement, n integer = 1) RETURNS anyelement
    LANGUAGE internal WINDOW IMMUTABLE STRICT COST 1
    AS 'window_nth_value';

CREATE FUNCTION public.gtsq_in(cstring) RETURNS gtsq
    AS '$libdir/tsearch2', $$'gtsq_in'$$
    LANGUAGE c STRICT;

