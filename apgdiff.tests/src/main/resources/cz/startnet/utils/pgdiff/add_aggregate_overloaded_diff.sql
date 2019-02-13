SET search_path = pg_catalog;

CREATE AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode11(boolean, integer, text ORDER BY text, boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode11(boolean, integer, text ORDER BY text, boolean) OWNER TO shamsutdinov_lr;