SET search_path = pg_catalog;

REVOKE ALL ON FUNCTION public.f(s text) FROM PUBLIC;
GRANT ALL ON FUNCTION public.f(s text) TO shamsutdinov_lr;