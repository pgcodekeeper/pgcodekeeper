CREATE TABLE public.tbl (
    c1 integer DEFAULT public.f(),
    c2 integer
);

ALTER TABLE public.tbl OWNER TO shamsutdinov_lr;

COMMENT ON COLUMN public.tbl.c1 IS 'some comment';