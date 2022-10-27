SET search_path = pg_catalog;

DROP TABLE public.t32;

CREATE UNLOGGED TABLE public.t31 (
	c1 integer
)
INHERITS (public.t1)
PARTITION BY RANGE (c2 COLLATE public.french varchar_pattern_ops)
WITH (autovacuum_enabled, fillfactor=80, OIDS=true)
TABLESPACE test_tablespace;

ALTER TABLE public.t31 ENABLE ROW LEVEL SECURITY;

ALTER TABLE ONLY public.t31 FORCE ROW LEVEL SECURITY;

CREATE TABLE public.t34 (
	c1 integer COMPRESSION lz4,
	c2 integer COMPRESSION pglz,
	c3 integer
);

ALTER TABLE public.t2
	SET LOGGED;

ALTER TABLE public.t3
	SET UNLOGGED;

ALTER TABLE public.t4
	NO INHERIT public.t1;

ALTER TABLE public.t4
	INHERIT public.t0;

ALTER TABLE public.t5
	INHERIT public.t0;

ALTER TABLE public.t6
	NO INHERIT public.t1;

ALTER TABLE public.t7
	INHERIT public.t1;

DROP TABLE public.t8;

DROP TABLE public.t9;

DROP TABLE public.t10;

DROP TABLE public.t11;

DROP TABLE public.t12;

DROP TABLE public.t13;

DROP TABLE public.t14;

ALTER TABLE public.t15 SET (fillfactor=80);

ALTER TABLE public.t16 RESET (fillfactor);

ALTER TABLE public.t17 SET (autovacuum_enabled='false', fillfactor=90);

ALTER TABLE public.t18 SET (autovacuum_enabled='false');

ALTER TABLE public.t18 RESET (fillfactor);

ALTER TABLE public.t19 RESET (fillfactor);

ALTER TABLE public.t20 SET (fillfactor=80);

ALTER TABLE public.t21
	SET TABLESPACE second_tablespace;

ALTER TABLE public.t22
	SET TABLESPACE pg_default;

ALTER TABLE public.t23
	SET TABLESPACE test_tablespace;

ALTER TABLE public.t24
	SET TABLESPACE pg_default;

ALTER TABLE ONLY public.t25 SET WITH OIDS;

ALTER TABLE ONLY public.t26 SET WITHOUT OIDS;

ALTER TABLE public.t27 DISABLE ROW LEVEL SECURITY;

ALTER TABLE public.t28 ENABLE ROW LEVEL SECURITY;

ALTER TABLE ONLY public.t29 NO FORCE ROW LEVEL SECURITY;

ALTER TABLE ONLY public.t30 FORCE ROW LEVEL SECURITY;

ALTER TABLE ONLY public.t33
	ALTER COLUMN c1 SET COMPRESSION DEFAULT;

ALTER TABLE ONLY public.t33
	ALTER COLUMN c2 SET COMPRESSION pglz;

ALTER TABLE ONLY public.t35
	ALTER COLUMN c1 SET COMPRESSION DEFAULT;

CREATE TABLE public.t8 (
	c1 integer,
	c2 character varying
);

CREATE TABLE public.t9 (
	c1 integer,
	c2 character varying
)
PARTITION BY LIST (c2);

CREATE TABLE public.t10 (
	c1 integer,
	c2 character varying
)
PARTITION BY LIST (c2);

CREATE TABLE public.t11 (
	c1 integer,
	c2 character varying
)
PARTITION BY RANGE (c2 COLLATE public.french varchar_pattern_ops);

CREATE TABLE public.t12 (
	c1 integer
)
USING gin;

CREATE TABLE public.t13 (
	c1 integer
);

CREATE TABLE public.t14 (
	c1 integer
)
USING hash;