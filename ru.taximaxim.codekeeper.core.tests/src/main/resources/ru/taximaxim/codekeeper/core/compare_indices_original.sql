CREATE TABLE public.test(
  id integer NOT NULL, 
  text character varying(20) NOT NULL, 
  vector tsvector NOT NULL,
  col4 numeric
);

-- no diff
CREATE INDEX CONCURRENTLY IF NOT EXISTS i1 ON ONLY public.test (id, text);

-- unique
CREATE UNIQUE INDEX i2 ON public.test (id, text);
CREATE INDEX i3 ON public.test (id, text);

-- method
CREATE INDEX i4 ON public.test using gin (vector);
CREATE INDEX i5 ON public.test (id, text);
CREATE INDEX i6 ON public.test using btree (id, text);

-- SimpleColumn
CREATE INDEX i7_1 ON public.test (text COLLATE public.french varchar_pattern_ops ASC NULLS FIRST);
CREATE INDEX i7_2 ON public.test (col4 numeric_minmax_multi_ops, text);
-- include
CREATE INDEX i8 ON public.test (id) INCLUDE (text);
CREATE INDEX i9 ON public.test (id) INCLUDE (text);
CREATE INDEX i10 ON public.test (id);

-- options
CREATE INDEX i11 ON public.test USING gin (vector) WITH (fastupdate);
CREATE INDEX i12 ON public.test USING gin (vector) WITH (fastupdate, fillfactor=70);
CREATE INDEX i13 ON public.test USING gin (vector) WITH (fastupdate, fillfactor=70);
CREATE INDEX i14 ON public.test USING gin (vector) WITH (fastupdate, fillfactor=70);
CREATE INDEX i15 ON public.test (id) WITH (fillfactor=70);
CREATE INDEX i16 ON public.test (id);

-- tablespace
CREATE INDEX i17 ON public.test (id, text) TABLESPACE test_tablespace;
CREATE INDEX i18 ON public.test (id, text) TABLESPACE test_tablespace;
CREATE INDEX i19 ON public.test (id, text);

SET default_tablespace = test_tablespace;

CREATE INDEX i20 ON public.test (id, text);

SET default_tablespace = '';

-- where
CREATE INDEX i21 ON public.test (id) WHERE (id > 0);
CREATE INDEX i22 ON public.test (id) WHERE (id > 0);
CREATE INDEX i23 ON public.test (id);

-- drop
CREATE INDEX i24 ON public.test USING gin (vector) INCLUDE (text) 
WITH (fastupdate, fillfactor=70)
TABLESPACE test_tablespace
WHERE (id > 0);

COMMENT ON INDEX public.i24 IS 'index to drop';