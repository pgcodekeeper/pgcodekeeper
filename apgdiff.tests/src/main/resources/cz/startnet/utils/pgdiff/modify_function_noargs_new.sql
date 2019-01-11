CREATE FUNCTION public.return_one() RETURNS integer
    AS $$
begin
	return -1 + 2;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.return_one() OWNER TO fordfrog;