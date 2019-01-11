CREATE FUNCTION public.test(OUT par1 bigint, OUT p2 text) RETURNS SETOF record
    LANGUAGE plpgsql
    AS $$begin null; end;$$;

ALTER FUNCTION public.test(OUT par1 bigint, OUT p2 text) OWNER TO botov_av;