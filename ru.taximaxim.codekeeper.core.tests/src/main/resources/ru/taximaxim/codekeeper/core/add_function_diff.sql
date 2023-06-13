SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.power_number(input integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	return input * input;
end;
$$;

ALTER FUNCTION public.power_number(input integer) OWNER TO fordfrog;

CREATE OR REPLACE FUNCTION public.multiply_numbers(number1 integer, number2 integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	return number1 * number2;
end;
$$;

ALTER FUNCTION public.multiply_numbers(number1 integer, number2 integer) OWNER TO fordfrog;

CREATE OR REPLACE FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) RETURNS smallint
    LANGUAGE plpgsql
    AS $$
begin
        return number2 * number1;
end;
$$;

ALTER FUNCTION public.multiply_numbers(number2 smallint, number1 smallint) OWNER TO fordfrog;

CREATE OR REPLACE FUNCTION public.return_one() RETURNS integer
    LANGUAGE plpgsql
    AS $$
begin
	return 1;
end;
$$;

ALTER FUNCTION public.return_one() OWNER TO fordfrog;

CREATE OR REPLACE FUNCTION public.tr_func() RETURNS integer
    LANGUAGE sql TRANSFORM FOR TYPE integer
    AS $$ select 1; $$;

CREATE OR REPLACE FUNCTION public.w_func(val anyelement, n integer = 1) RETURNS anyelement
    LANGUAGE internal WINDOW IMMUTABLE STRICT
    AS $$window_nth_value$$;

CREATE OR REPLACE FUNCTION public.gtsq_in(cstring) RETURNS gtsq
    LANGUAGE c STRICT
    AS '$libdir/tsearch2', $$'gtsq_in'$$;