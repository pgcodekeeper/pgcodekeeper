SET search_path = pg_catalog;

DROP AGGREGATE public.aggregate_ee_income_tax(double precision);

DROP AGGREGATE public.aggregate_ee_income_tax2(double precision);

DROP AGGREGATE public.greatest_running_total(double precision);

DROP AGGREGATE public.mode1(boolean);

DROP AGGREGATE public.mode10(boolean);

DROP AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text);

DROP AGGREGATE public.mode12(boolean ORDER BY boolean);

DROP AGGREGATE public.mode13(ORDER BY boolean, text, integer);

DROP AGGREGATE public.mode2(boolean);

DROP AGGREGATE public.mode3(*);

DROP AGGREGATE public.mode4(ORDER BY boolean);

DROP AGGREGATE public.mode5(boolean ORDER BY boolean);

DROP AGGREGATE public.mode6(boolean);

DROP AGGREGATE public.mode7(boolean);

DROP AGGREGATE public.mode8(boolean ORDER BY boolean);

DROP AGGREGATE public.mode9(boolean ORDER BY boolean);

DROP AGGREGATE public.mode_seria(internal);