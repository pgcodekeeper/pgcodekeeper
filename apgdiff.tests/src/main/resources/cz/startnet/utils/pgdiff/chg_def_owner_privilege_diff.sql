SET search_path = pg_catalog;

REVOKE ALL ON TYPE public.t FROM PUBLIC;
GRANT ALL ON TYPE public.t TO shamsutdinov_lr;

REVOKE ALL ON FUNCTION public.f(s text) FROM PUBLIC;
GRANT ALL ON FUNCTION public.f(s text) TO shamsutdinov_lr;

REVOKE ALL ON TABLE public.tbl FROM PUBLIC;
REVOKE ALL ON TABLE public.tbl FROM shamsutdinov_lr;
GRANT ALL ON TABLE public.tbl TO shamsutdinov_lr;