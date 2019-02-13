SET search_path = pg_catalog;

CREATE AGGREGATE public.mode1(boolean) (
	SFUNC = tester.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = tester.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

COMMENT ON AGGREGATE public.mode1(boolean) IS 'sdfsdf';