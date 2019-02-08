SET search_path = pg_catalog;

DROP AGGREGATE public.mode5(boolean ORDER BY boolean);

CREATE AGGREGATE public.mode5(boolean ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}',
	PARALLEL = SAFE,
	HYPOTHETICAL
);

ALTER AGGREGATE public.mode5(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;