CREATE VIEW public.v1 AS
	SELECT 1 AS first,
    2 AS second,
    3 AS third;

COMMENT ON COLUMN public.v1.first IS 'one';

COMMENT ON COLUMN public.v1.second IS 'two';

COMMENT ON COLUMN public.v1.third IS 'three';
