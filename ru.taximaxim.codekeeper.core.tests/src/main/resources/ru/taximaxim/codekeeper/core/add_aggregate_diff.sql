SET search_path = pg_catalog;

CREATE AGGREGATE public.aggregate_ee_income_tax(double precision) (
	SFUNC = float8pl,
	STYPE = double precision,
	FINALFUNC = public.eeincometax,
	INITCOND = '0'
);

ALTER AGGREGATE public.aggregate_ee_income_tax(double precision) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.aggregate_ee_income_tax2(double precision) (
	SFUNC = float8pl,
	STYPE = double precision,
	FINALFUNC = public.eeincometax,
	INITCOND = '0.0'
);

ALTER AGGREGATE public.aggregate_ee_income_tax2(double precision) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.greatest_running_total(double precision) (
	SFUNC = public.grt_sfunc,
	STYPE = point,
	FINALFUNC = public.grt_finalfunc
);

ALTER AGGREGATE public.greatest_running_total(double precision) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode1(boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

COMMENT ON AGGREGATE public.mode1(boolean) IS 'sdfsdf';

CREATE AGGREGATE public.mode10(boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{10}'
);

ALTER AGGREGATE public.mode10(boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode12(boolean ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}',
	HYPOTHETICAL
);

ALTER AGGREGATE public.mode12(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode13(ORDER BY boolean, text, integer) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode13(ORDER BY boolean, text, integer) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode2(boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode2(boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode3(*) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode3(*) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode4(ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode4(ORDER BY boolean) OWNER TO shamsutdinov_lr;

COMMENT ON AGGREGATE public.mode4(ORDER BY boolean) IS 's1111111';

CREATE AGGREGATE public.mode5(boolean ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode5(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode6(boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode6(boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode7(boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	FINALFUNC_MODIFY = READ_WRITE,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode7(boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode8(boolean ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode8(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode9(boolean ORDER BY boolean) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	FINALFUNC_MODIFY = READ_ONLY,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode9(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode_seria(internal) (
	SFUNC = inet_gist_picksplit,
	STYPE = internal,
	SERIALFUNC = numeric_poly_serialize,
	DESERIALFUNC = numeric_poly_deserialize,
	INITCOND = '{0,0}'
);

ALTER AGGREGATE public.mode_seria(internal) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.aggregate_with_args3(TEXT) (
	SFUNC = TEST_FUNCC,
	STYPE = TEXT,
	FINALFUNC = TEST_FUNCC,
	MSFUNC = test_func,
	MINVFUNC = test_func,
	MSTYPE = text
);