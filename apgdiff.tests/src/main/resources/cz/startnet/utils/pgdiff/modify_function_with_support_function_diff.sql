SET search_path = pg_catalog;

ALTER FUNCTION public.f_sp(s text)
	SUPPORT tester.my_support2;

ALTER FUNCTION public.f_sp_2(s text)
	SUPPORT public.my_support;
