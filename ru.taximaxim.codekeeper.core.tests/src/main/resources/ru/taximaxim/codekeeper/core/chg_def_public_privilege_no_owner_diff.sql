SET search_path = pg_catalog;

GRANT ALL ON TYPE public.t TO PUBLIC;

REVOKE ALL ON TABLE public.tbl FROM PUBLIC;

GRANT ALL ON FUNCTION public.f(s text) TO PUBLIC;

GRANT ALL ON FUNCTION public.f3(s text) TO PUBLIC;

REVOKE ALL ON FUNCTION public.f3(s text) FROM PUBLIC;

GRANT ALL ON FUNCTION public.f4(s text) TO PUBLIC;