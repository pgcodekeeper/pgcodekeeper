-- unlogged
CREATE TABLE public.t2 (c1 integer);
CREATE UNLOGGED TABLE public.t3 (c1 integer);

-- inherits
CREATE TABLE public.t4 (c1 integer) INHERITS (public.t0);
CREATE TABLE public.t5 (c1 integer) INHERITS (public.t0, public.t1);
CREATE TABLE public.t6 (c1 integer);
CREATE TABLE public.t7 (c1 integer) INHERITS (public.t1);

-- partition by
CREATE TABLE public.t8 (c1 integer, c2 varchar);
CREATE TABLE public.t9 (c1 integer, c2 varchar) PARTITION BY LIST (c2);
CREATE TABLE public.t10 (c1 integer, c2 varchar) PARTITION BY LIST (c2);
CREATE TABLE public.t11 (c1 integer, c2 varchar) PARTITION BY RANGE (c2 COLLATE public.french varchar_pattern_ops);

-- using method
CREATE TABLE public.t12 (c1 integer) USING gin;
CREATE TABLE public.t13 (c1 integer);
CREATE TABLE public.t14 (c1 integer) USING hash;

-- with options
CREATE TABLE public.t15 (c1 integer) WITH (autovacuum_enabled, fillfactor = 80);
CREATE TABLE public.t16 (c1 integer) WITH (autovacuum_enabled);
CREATE TABLE public.t17 (c1 integer) WITH (autovacuum_enabled='false', fillfactor = 90);
CREATE TABLE public.t18 (c1 integer) WITH (autovacuum_enabled='false');
CREATE TABLE public.t19 (c1 integer);
CREATE TABLE public.t20 (c1 integer) WITH (fillfactor = 80);

-- tablespace
CREATE TABLE public.t21 (c1 integer) TABLESPACE second_tablespace;
CREATE TABLE public.t22 (c1 integer);
CREATE TABLE public.t23 (c1 integer) TABLESPACE test_tablespace;
CREATE TABLE public.t24 (c1 integer);

-- oid
CREATE TABLE public.t25 (c1 integer) WITH OIDS;
CREATE TABLE public.t26 (c1 integer);

-- row level security 
CREATE TABLE public.t27 (c1 integer);
CREATE TABLE public.t28 (c1 integer);
CREATE TABLE public.t29 (c1 integer);
CREATE TABLE public.t30 (c1 integer);

ALTER TABLE public.t28 ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.t30 FORCE ROW LEVEL SECURITY;

-- create
CREATE UNLOGGED TABLE public.t31 (c1 integer) INHERITS (public.t1)
PARTITION BY RANGE (c2 COLLATE public.french varchar_pattern_ops)
WITH (autovacuum_enabled, fillfactor = 80, oids = true)
TABLESPACE test_tablespace;

ALTER TABLE ONLY public.t31 ENABLE ROW LEVEL SECURITY;
ALTER TABLE ONLY public.t31 FORCE ROW LEVEL SECURITY;

-- compression
CREATE TABLE public.t33 (c1 integer, c2 integer COMPRESSION pglz);
CREATE TABLE public.t34 (c1 integer COMPRESSION lz4, c2 integer COMPRESSION pglz, c3 integer);
CREATE TABLE public.t35 (c1 integer COMPRESSION DEFAULT, c2 integer);

-- partition
CREATE TABLE public.t36(a int, b int, c int)
DISTRIBUTED BY (a)
PARTITION BY RANGE (b)
SUBPARTITION BY RANGE (c)
SUBPARTITION TEMPLATE (START (11) END (12) EVERY (1))
(START (1) END (2) EVERY (1)); 