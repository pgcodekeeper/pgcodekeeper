SET search_path = pg_catalog;

CREATE AGGREGATE public.mode1(boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.mode1(boolean) TO test_user;

CREATE AGGREGATE public.mode3(*) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode3(*) OWNER TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.mode3() TO test_user;

CREATE AGGREGATE public.mode4(ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode4(ORDER BY boolean) OWNER TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.mode4(boolean) TO test_user;

CREATE AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;

GRANT ALL ON FUNCTION public.mode11(boolean, integer, text, boolean, text) TO test_user;