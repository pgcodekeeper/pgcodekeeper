SET search_path = pg_catalog;

CREATE AGGREGATE public.test(VARIADIC "any" ORDER BY VARIADIC "any") (
	SFUNC = ordered_set_transition_multi,
	STYPE = internal,
	FINALFUNC = rank_final,
	FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test(VARIADIC "any" ORDER BY VARIADIC "any") OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.test2(VARIADIC "any") (
	SFUNC = ordered_set_transition_multi,
	STYPE = internal,
	FINALFUNC = rank_final,
	FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test2(VARIADIC "any") OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.test3(ORDER BY VARIADIC "any") (
	SFUNC = ordered_set_transition_multi,
	STYPE = internal,
	FINALFUNC = rank_final,
	FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test3(ORDER BY VARIADIC "any") OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.test4(boolean, boolean, VARIADIC "any") (
	SFUNC = public.ordered_set_transition_multi,
	STYPE = internal,
	FINALFUNC = public.rank_final,
	FINALFUNC_EXTRA
);

ALTER AGGREGATE public.test4(boolean, boolean, VARIADIC "any") OWNER TO shamsutdinov_lr;
