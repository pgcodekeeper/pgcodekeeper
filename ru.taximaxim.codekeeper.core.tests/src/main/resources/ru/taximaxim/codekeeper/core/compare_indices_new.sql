CREATE TABLE public.test(
  id integer NOT NULL, 
  text character varying(20) NOT NULL, 
  vector tsvector NOT NULL,
  col4 numeric
);

-- no diff
CREATE INDEX i1 ON public.test (id, text);

-- unique
CREATE INDEX i2 ON public.test (id, text);
CREATE UNIQUE INDEX i3 ON public.test (id, text);

-- method
CREATE INDEX i4 ON public.test USING gist (vector);
CREATE INDEX i5 ON public.test USING btree (id, text);
CREATE INDEX i6 ON public.test (id, text);

-- SimpleColumn
CREATE INDEX i7_1 ON public.test (text COLLATE public.french varchar_pattern_ops DESC NULLS LAST);
CREATE INDEX i7_2 ON public.test (col4 numeric_minmax_multi_ops (values_per_range='32'), text COLLATE public.french varchar_pattern_ops);

-- include
CREATE INDEX i8 ON public.test (id) INCLUDE (vector, text);
CREATE INDEX i9 ON public.test (id);
CREATE INDEX i10 ON public.test (id) INCLUDE (text);

-- options
CREATE INDEX i11 ON public.test USING gin (vector) WITH (fastupdate, fillfactor=70);
CREATE INDEX i12 ON public.test USING gin (vector) WITH (fastupdate);
CREATE INDEX i13 ON public.test USING gin (vector) WITH (fastupdate='false', fillfactor=90);
CREATE INDEX i14 ON public.test USING gin (vector) WITH (fastupdate='false');
CREATE INDEX i15 ON public.test (id);
CREATE INDEX i16 ON public.test (id) WITH (fillfactor=70);

-- tablespace
CREATE INDEX i17 ON public.test (id, text) TABLESPACE second_tablespace;
CREATE INDEX i18 ON public.test (id, text);
CREATE INDEX i19 ON public.test (id, text) TABLESPACE test_tablespace;
CREATE INDEX i20 ON public.test (id, text) TABLESPACE test_tablespace;

-- where
CREATE INDEX i21 ON public.test (id) WHERE (id < 0);
CREATE INDEX i22 ON public.test (id);
CREATE INDEX i23 ON public.test (id) WHERE (id > 0);

-- create
CREATE INDEX i25 ON public.test USING gin (vector) INCLUDE (text) 
WITH (fastupdate, fillfactor=70)
TABLESPACE test_tablespace
WHERE (id > 0);

COMMENT ON INDEX public.i25 IS 'index to create';
