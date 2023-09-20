CREATE LOCAL TEMP TABLE public.t0 ();
CREATE GLOBAL TEMPORARY TABLE IF NOT EXISTS public.t1 (c1 integer) ON COMMIT DELETE ROWS;

-- with options
CREATE TABLE public.t2 (c1 integer) WITH (fillfactor=80, autovacuum_enabled);

-- tablespace
SET default_tablespace = test_tablespace;

CREATE TABLE public.t3 (c1 integer);

SET default_tablespace = '';

-- oid
CREATE TABLE public.t4 (c1 integer) WITHOUT OIDS;

-- storage
CREATE TABLE public.t5 (c1 text STORAGE MAIN);