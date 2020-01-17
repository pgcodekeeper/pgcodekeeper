SET search_path = pg_catalog;

CREATE OR REPLACE FUNCTION public.f1() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
  RETURN OLD;
END;
$$;