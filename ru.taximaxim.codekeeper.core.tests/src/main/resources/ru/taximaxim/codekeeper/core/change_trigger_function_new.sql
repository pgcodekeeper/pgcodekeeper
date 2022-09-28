CREATE SCHEMA another_triggers;

CREATE FUNCTION another_triggers.test_table_trigger_another() RETURNS trigger
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
FOR EACH ROW EXECUTE PROCEDURE another_triggers.test_table_trigger_another();