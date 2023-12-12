SET search_path = pg_catalog;

DROP INDEX public.i24;

CREATE INDEX i25 ON public.test USING gin (vector) INCLUDE (text)
WITH (fastupdate, fillfactor=70)
TABLESPACE test_tablespace
WHERE (id > 0);

COMMENT ON INDEX public.i25 IS 'index to create';

DROP INDEX public.i2;

DROP INDEX public.i3;

DROP INDEX public.i4;

DROP INDEX public.i5;

DROP INDEX public.i6;

DROP INDEX public.i7_1;

DROP INDEX public.i7_2;

DROP INDEX public.i8;

DROP INDEX public.i9;

DROP INDEX public.i10;

ALTER INDEX public.i11 SET (fillfactor=70);

ALTER INDEX public.i12 RESET (fillfactor);

ALTER INDEX public.i13 SET (fastupdate='false', fillfactor=90);

ALTER INDEX public.i14 SET (fastupdate='false');

ALTER INDEX public.i14 RESET (fillfactor);

ALTER INDEX public.i15 RESET (fillfactor);

ALTER INDEX public.i16 SET (fillfactor=70);

ALTER INDEX public.i17 SET TABLESPACE second_tablespace;

ALTER INDEX public.i18 SET TABLESPACE pg_default;

ALTER INDEX public.i19 SET TABLESPACE test_tablespace;

DROP INDEX public.i21;

DROP INDEX public.i22;

DROP INDEX public.i23;

CREATE INDEX i2 ON public.test (id, text);

CREATE UNIQUE INDEX i3 ON public.test (id, text);

CREATE INDEX i4 ON public.test USING gist (vector);

CREATE INDEX i5 ON public.test USING btree (id, text);

CREATE INDEX i6 ON public.test (id, text);

CREATE INDEX i7_1 ON public.test (text COLLATE public.french varchar_pattern_ops DESC NULLS LAST);

CREATE INDEX i7_2 ON public.test (col4 numeric_minmax_multi_ops (values_per_range='32'), text COLLATE public.french varchar_pattern_ops);

CREATE INDEX i8 ON public.test (id) INCLUDE (vector, text);

CREATE INDEX i9 ON public.test (id);

CREATE INDEX i10 ON public.test (id) INCLUDE (text);

CREATE INDEX i21 ON public.test (id)
WHERE (id < 0);

CREATE INDEX i22 ON public.test (id);

CREATE INDEX i23 ON public.test (id)
WHERE (id > 0);