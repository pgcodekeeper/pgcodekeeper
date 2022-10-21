SET search_path = pg_catalog;

ALTER TABLE ONLY public.t01 SET ACCESS METHOD heap;

ALTER TABLE ONLY public.t03 SET ACCESS METHOD my_method;

ALTER TABLE ONLY public.employees SET ACCESS METHOD my_method;

ALTER TABLE ONLY public.measurement_ym_older SET ACCESS METHOD my_method;

ALTER TABLE ONLY public.measurement_ym_y2016m12 SET ACCESS METHOD heap;

ALTER TABLE ONLY public.t11 SET ACCESS METHOD my_method;