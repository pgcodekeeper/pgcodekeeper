SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.notify_change() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    RAISE WARNING 'table changed';
    RETURN NEW;
    IF TG_OP = 'INSERT' THEN
        RETURN NEW;
    ELSE 
        RETURN OLD;
    END IF;
END;
$$;

ALTER FUNCTION public.notify_change() OWNER TO galiev_mr;

CREATE TRIGGER multi_event_trig
	AFTER INSERT OR DELETE OR TRUNCATE ON public.t1
	FOR EACH STATEMENT
	EXECUTE PROCEDURE public.notify_change();
