CREATE FUNCTION public.test_table_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	return NEW;
end;
$$;

CREATE TABLE public.test_table (
    id integer NOT NULL
);

CREATE TRIGGER test_table_trigger 
BEFORE INSERT OR UPDATE ON public.test_table 
FOR EACH ROW EXECUTE PROCEDURE public.test_table_trigger();
