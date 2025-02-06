-- no diff
CREATE AGGREGATE public.t1(*) (SFUNC = int8inc, STYPE = int8);
CREATE AGGREGATE public.t2(bigint) (SFUNC = int8_avg_accum, STYPE = internal);

CREATE AGGREGATE public.aggregate_with_args1(text) (
    SFUNC = test_funcc(123, 345, "test", drop, NULL, 412 / 634),
    STYPE = text, 
    FINALFUNC = test_funcc(123, 345, "test", NULL, 124 % 5),
    SERIALFUNC = numeric_avg_serialize(drop, drop, 235),
    DESERIALFUNC = numeric_avg_deserialize((EXISTS (SELECT * FROM public.test), "test" IS NOT DOCUMENT)),
    MSFUNC = numeric_avg_serialize((124, DROP, test)),
    FINALFUNC_MODIFY = READ_ONLY,
    MFINALFUNC_MODIFY = READ_ONLY
);

CREATE AGGREGATE public.aggregate_with_args2(TEXT) (
    SFUNC = TEST_FUNCC (
        TEXT,
        CASE
            WHEN LENGTH(NAME) > 6 THEN 'long'
            ELSE 'short'
        END
    ),
    STYPE = TEXT,
    FINALFUNC = TEST_FUNCC(EXISTS (SELECT * FROM public.test), "test" IS NOT DOCUMENT),
    FINALFUNC_MODIFY = READ_ONLY,
	MSFUNC = test_func(5 ^ 5),
    MINVFUNC = test_func(5 AT TIME ZONE 2),
    MSTYPE = text,
    MFINALFUNC_MODIFY = READ_ONLY
);