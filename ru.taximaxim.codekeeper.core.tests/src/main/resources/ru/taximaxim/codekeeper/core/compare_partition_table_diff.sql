SET search_path = pg_catalog;

DROP TABLE public.cities_fg;

DROP TABLE public.cities_4544;

-- DEPCY: This TABLE measurement_2 depends on the TABLE: public.measurement

DROP TABLE public.measurement_2;

-- DEPCY: This TABLE measurement_1 depends on the TABLE: public.measurement

DROP TABLE public.measurement_1;

DROP TABLE public.measurement;

-- DEPCY: This TABLE towns depends on the TABLE: public.cities

DROP TABLE public.towns;

-- DEPCY: This TABLE cities_cd_10_to_103 depends on the TABLE: public.cities

DROP TABLE public.cities_cd_10_to_103;

-- DEPCY: This TABLE cities_cd_10_to_102 depends on the TABLE: public.cities

DROP TABLE public.cities_cd_10_to_102;

-- DEPCY: This TABLE cities57 depends on the TABLE: public.cities

DROP TABLE public.cities57;

-- DEPCY: This TABLE cities56 depends on the TABLE: public.cities

DROP TABLE public.cities56;

-- DEPCY: This TABLE cities_cd_10_to_100 depends on the TABLE: public.cities

DROP TABLE public.cities_cd_10_to_100;

-- DEPCY: This CONSTRAINT constr_check depends on the TABLE: public.cities

ALTER TABLE public.cities_cd
	DROP CONSTRAINT constr_check;

-- DEPCY: This TABLE cities_cd depends on the TABLE: public.cities

DROP TABLE public.cities_cd;

DROP TABLE public.cities;

CREATE TABLE public.measurement (
	id_key bigint,
	id bigint,
	city_id integer NOT NULL,
	logdate integer
)
PARTITION BY RANGE (logdate);

ALTER TABLE public.measurement OWNER TO khazieva_gr;

CREATE TABLE public.cities (
	c0 integer,
	c1 integer,
	c2 text,
	c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.cities OWNER TO khazieva_gr;

CREATE TABLE public.measurement_2 PARTITION OF public.measurement
FOR VALUES FROM (6) TO (10);

ALTER TABLE public.measurement_2 OWNER TO khazieva_gr;

CREATE TABLE public.measurement_1 PARTITION OF public.measurement
FOR VALUES FROM (1) TO (5);

ALTER TABLE public.measurement_1 OWNER TO khazieva_gr;

CREATE TABLE public.towns PARTITION OF public.cities
FOR VALUES FROM ('1') TO ('100');

ALTER TABLE public.towns OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd PARTITION OF public.cities
FOR VALUES IN ('c', 'd')
PARTITION BY RANGE (c3);

ALTER TABLE public.cities_cd OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd_10_to_103 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities_cd_10_to_103 OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd_10_to_102 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities_cd_10_to_102 OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd_10_to_100 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('100')
PARTITION BY RANGE (c3);

ALTER TABLE public.cities_cd_10_to_100 OWNER TO khazieva_gr;

CREATE TABLE public.cities57 PARTITION OF public.cities_cd_10_to_100
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities57 OWNER TO khazieva_gr;

CREATE TABLE public.cities56 PARTITION OF public.cities_cd_10_to_100
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities56 OWNER TO khazieva_gr;

ALTER TABLE public.cities_cd
	ADD CONSTRAINT constr_check CHECK ((c1 > 5));