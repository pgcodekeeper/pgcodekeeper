-- unlogged
CREATE UNLOGGED TABLE public.t2 (c1 integer);
CREATE TABLE public.t3 (c1 integer);

-- inherits
CREATE TABLE public.t4 (c1 integer) INHERITS (public.t1);
CREATE TABLE public.t5 (c1 integer) INHERITS (public.t1);
CREATE TABLE public.t6 (c1 integer) INHERITS (public.t1);
CREATE TABLE public.t7 (c1 integer);

-- partition by
CREATE TABLE public.t8 (c1 integer, c2 varchar) PARTITION BY RANGE (c2 COLLATE public.french varchar_pattern_ops);
CREATE TABLE public.t9 (c1 integer, c2 varchar) PARTITION BY LIST (c1);
CREATE TABLE public.t10 (c1 integer, c2 varchar) PARTITION BY HASH (c2);
CREATE TABLE public.t11 (c1 integer, c2 varchar);

-- using method
CREATE TABLE public.t12 (c1 integer) USING hash;
CREATE TABLE public.t13 (c1 integer) USING hash;
CREATE TABLE public.t14 (c1 integer);

-- with options
CREATE TABLE public.t15 (c1 integer) WITH (autovacuum_enabled);
CREATE TABLE public.t16 (c1 integer) WITH (autovacuum_enabled, fillfactor = 80);
CREATE TABLE public.t17 (c1 integer) WITH (autovacuum_enabled, fillfactor = 80);
CREATE TABLE public.t18 (c1 integer) WITH (autovacuum_enabled, fillfactor = 80);
CREATE TABLE public.t19 (c1 integer) WITH (fillfactor = 80);
CREATE TABLE public.t20 (c1 integer);

-- tablespace
CREATE TABLE public.t21 (c1 integer) TABLESPACE test_tablespace;
CREATE TABLE public.t22 (c1 integer) TABLESPACE test_tablespace;
CREATE TABLE public.t23 (c1 integer);

SET default_tablespace = test_tablespace;

CREATE TABLE public.t24 (c1 integer);

SET default_tablespace = '';

-- oid
CREATE TABLE public.t25 (c1 integer) WITHOUT OIDS;
CREATE TABLE public.t26 (c1 integer) WITH OIDS;

-- row level security 
CREATE TABLE public.t27 (c1 integer);
CREATE TABLE public.t28 (c1 integer);
CREATE TABLE public.t29 (c1 integer);
CREATE TABLE public.t30 (c1 integer);

ALTER TABLE public.t27 ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.t29 FORCE ROW LEVEL SECURITY;

-- drop
CREATE UNLOGGED TABLE public.t32 (c1 integer) INHERITS (public.t1)
PARTITION BY RANGE (c2 COLLATE public.french varchar_pattern_ops)
USING hash
WITH (autovacuum_enabled, fillfactor = 80, oids = true)
TABLESPACE test_tablespace;

-- compression
CREATE TABLE public.t33 (c1 integer COMPRESSION lz4, c2 integer);
CREATE TABLE public.t35 (c1 integer COMPRESSION pglz, c2 integer);

-- partition
CREATE TABLE public.t36(a int, b int, c int) DISTRIBUTED BY (a) PARTITION BY RANGE (b)
SUBPARTITION BY RANGE (c) SUBPARTITION TEMPLATE (START (11) END (12) EVERY (1)) (START (1) END (2) EVERY (1));