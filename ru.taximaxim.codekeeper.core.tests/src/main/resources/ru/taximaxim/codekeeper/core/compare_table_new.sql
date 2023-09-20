CREATE LOCAL TEMP TABLE public.t0 ();
CREATE TABLE public.t1 (c1 integer);

-- with options
CREATE TABLE public.t2 (c1 integer) WITH (autovacuum_enabled, fillfactor = 80);

-- tablespace
CREATE TABLE public.t3 (c1 integer) TABLESPACE test_tablespace;

-- oid
CREATE TABLE public.t4 (c1 integer);

-- storage
CREATE TABLE public.t5 (c1 text);
ALTER TABLE public.t5 ALTER COLUMN c1 SET STORAGE MAIN;