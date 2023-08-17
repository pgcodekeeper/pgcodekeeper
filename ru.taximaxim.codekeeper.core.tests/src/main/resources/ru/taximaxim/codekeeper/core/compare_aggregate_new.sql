-- no diff
CREATE AGGREGATE public.t1(*) (SFUNC = int8inc, STYPE = int8);
CREATE AGGREGATE public.t2(bigint) (SFUNC = int8_avg_accum, STYPE = internal);