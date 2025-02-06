-- no diff
CREATE AGGREGATE public.t1 (BASETYPE = ANY, SFUNC = int8inc, STYPE = int8);
CREATE AGGREGATE public.t2 (BASETYPE = bigint, SFUNC = int8_avg_accum, STYPE = internal);

CREATE AGGREGATE public.aggregate_with_args1(text) (
	SFUNC = test_funcc,
	STYPE = text,
	FINALFUNC = test_funcc,
	SERIALFUNC = numeric_avg_serialize,
	DESERIALFUNC = numeric_avg_deserialize,
	MSFUNC = numeric_avg_serialize
);

CREATE AGGREGATE public.aggregate_with_args2(TEXT) (
	SFUNC = TEST_FUNCC,
	STYPE = TEXT,
	FINALFUNC = TEST_FUNCC,
	MSFUNC = test_func,
	MINVFUNC = test_func,
	MSTYPE = text
);