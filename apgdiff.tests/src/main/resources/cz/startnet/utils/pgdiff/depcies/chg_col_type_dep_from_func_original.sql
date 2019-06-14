CREATE OR REPLACE FUNCTION public.f() RETURNS integer
    LANGUAGE plpgsql STABLE
    AS $$
BEGIN
  RETURN 1::integer;
END
$$;

ALTER FUNCTION public.f() OWNER TO shamsutdinov_lr;

CREATE TABLE public.tbl (
    c1 integer DEFAULT public.f(),
    c2 integer
);

ALTER TABLE public.tbl OWNER TO shamsutdinov_lr;

COMMENT ON COLUMN public.tbl.c1 IS 'some comment';