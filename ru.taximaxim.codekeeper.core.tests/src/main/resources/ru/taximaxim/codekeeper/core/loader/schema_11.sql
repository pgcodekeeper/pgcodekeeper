CREATE FUNCTION public.curdate() RETURNS date
    LANGUAGE sql
    AS $$SELECT CAST('now' AS date);
$$;
