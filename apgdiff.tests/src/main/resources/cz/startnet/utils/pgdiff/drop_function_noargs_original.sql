CREATE FUNCTION public.return_one() RETURNS integer
    AS $$
begin
	return 1;
end;
$$
    LANGUAGE plpgsql;