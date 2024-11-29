SET search_path = pg_catalog;

GRANT ALL ON TYPE public.t TO PUBLIC;

REVOKE ALL ON TYPE public.t FROM shamsutdinov_lr;

GRANT ALL ON TYPE public.t TO shamsutdinov_lr;

REVOKE ALL ON TYPE public.t FROM PUBLIC;

REVOKE ALL ON TABLE public.tbl FROM PUBLIC;

REVOKE ALL ON TABLE public.tbl FROM shamsutdinov_lr;

GRANT ALL ON TABLE public.tbl TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.f(s text) TO PUBLIC;

REVOKE ALL ON FUNCTION public.f(s text) FROM shamsutdinov_lr;

GRANT ALL ON FUNCTION public.f(s text) TO shamsutdinov_lr;

REVOKE ALL ON FUNCTION public.f(s text) FROM PUBLIC;