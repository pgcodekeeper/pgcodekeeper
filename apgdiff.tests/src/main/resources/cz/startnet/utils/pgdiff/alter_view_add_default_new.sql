CREATE VIEW public.test2 AS
	SELECT 1 AS test_col;

CREATE VIEW public.test AS
	SELECT test_col FROM public.test2;

ALTER VIEW public.test ALTER COLUMN test_col SET DEFAULT now();
