CREATE FUNCTION public.test(OUT p1 integer, OUT p2 text, IN dummy text, OUT p3 text) RETURNS SETOF record
    LANGUAGE plpgsql
    AS $$begin null; end;$$;


ALTER FUNCTION public.test(OUT p1 integer, OUT p2 text, IN dummy text, OUT p3 text) OWNER TO botov_av;