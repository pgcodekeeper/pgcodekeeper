SET search_path = pg_catalog;

DROP FUNCTION public.test(OUT p1 integer, OUT p2 text);

CREATE OR REPLACE FUNCTION public.test(OUT par1 bigint, OUT p2 text) RETURNS SETOF record
    LANGUAGE plpgsql
    AS $$begin null; end;$$;

ALTER FUNCTION public.test(OUT par1 bigint, OUT p2 text) OWNER TO botov_av;