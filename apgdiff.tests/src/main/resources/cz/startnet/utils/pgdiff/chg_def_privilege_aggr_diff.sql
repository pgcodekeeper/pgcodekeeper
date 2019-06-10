SET search_path = pg_catalog;

REVOKE ALL ON FUNCTION public.mode1(boolean) FROM PUBLIC;
GRANT ALL ON FUNCTION public.mode1(boolean) TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.mode2(boolean) TO PUBLIC;
REVOKE ALL ON FUNCTION public.mode2(boolean) FROM shamsutdinov_lr;
GRANT ALL ON FUNCTION public.mode2(boolean) TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.mode3(boolean) TO PUBLIC;
REVOKE ALL ON FUNCTION public.mode3(boolean) FROM shamsutdinov_lr;
GRANT ALL ON FUNCTION public.mode3(boolean) TO shamsutdinov_lr;
