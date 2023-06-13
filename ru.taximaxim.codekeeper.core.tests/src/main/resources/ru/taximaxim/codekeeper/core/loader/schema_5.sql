-- WARNING: THIS FILE INTENTIONALLY CONTAINS MIXED \n AND \r\n NEWLINES!
-- EDIT WITH NOTEPAD++ OR SIMILAR EDITOR
CREATE FUNCTION public.gtsq_in(cstring) RETURNS gtsq
    AS '$libdir/tsearch2', $$gtsq_in$$
    LANGUAGE c STRICT;

CREATE FUNCTION public.multiply_numbers(number1 integer, number2 integer) RETURNS integer
    AS $$
begin
	return number1 * number2;
end;
$$
    LANGUAGE plpgsql STRICT;

CREATE FUNCTION public.select_something(number1 integer, number2 integer) RETURNS integer
    AS $_$SELECT number1 * number2$_$ LANGUAGE sql;

CREATE FUNCTION public.select_something2(number1 integer, number2 integer) RETURNS integer
    AS 'SELECT number1 * number2 || ''text''' LANGUAGE sql;

CREATE FUNCTION public.select_something3(number1 integer, number2 integer) RETURNS integer
    AS '
SELECT number1 * number2 || ''text''
' LANGUAGE sql;
