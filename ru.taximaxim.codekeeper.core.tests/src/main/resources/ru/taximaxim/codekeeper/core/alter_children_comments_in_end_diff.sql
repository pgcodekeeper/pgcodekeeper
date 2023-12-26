SET search_path = pg_catalog;

COMMENT ON COLUMN public.ct1.c1 IS 'type column comment change';

COMMENT ON COLUMN public.ct1.c2 IS 'type column comment add';

COMMENT ON COLUMN public.ct1.c3 IS NULL;

COMMENT ON CONSTRAINT d1_check1 ON DOMAIN public.d1 IS 'CONSTRAINT change';

COMMENT ON CONSTRAINT d1_check2 ON DOMAIN public.d1 IS 'CONSTRAINT comment add';

COMMENT ON CONSTRAINT d1_check3 ON DOMAIN public.d1 IS NULL;

COMMENT ON COLUMN public.t1.c1 IS 'table column comment change';

COMMENT ON COLUMN public.t1.c2 IS 'table column comment add';

COMMENT ON COLUMN public.t1.c3 IS NULL;

COMMENT ON COLUMN public.v1.c1 IS 'view column comment change';

COMMENT ON COLUMN public.v1.c2 IS 'view column comment add';

COMMENT ON COLUMN public.v1.c3 IS NULL;