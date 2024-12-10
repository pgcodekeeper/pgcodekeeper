SET search_path = pg_catalog;

DROP TABLE public.cities_fg;

DROP TABLE public.cities_4544;

ALTER TABLE public.measurement_2 RENAME TO measurement_2_randomly_generated_part;

ALTER TABLE public.measurement_1 RENAME TO measurement_1_randomly_generated_part;

ALTER TABLE public.measurement RENAME TO measurement_randomly_generated_part;

ALTER TABLE public.towns RENAME TO towns_randomly_generated_part;

ALTER TABLE public.cities_cd_10_to_103 RENAME TO cities_cd_10_to_103_randomly_generated_part;

ALTER TABLE public.cities_cd_10_to_102 RENAME TO cities_cd_10_to_102_randomly_generated_part;

ALTER TABLE public.cities57 RENAME TO cities57_randomly_generated_part;

ALTER TABLE public.cities56 RENAME TO cities56_randomly_generated_part;

ALTER TABLE public.cities_cd_10_to_100 RENAME TO cities_cd_10_to_100_randomly_generated_part;

-- DEPCY: This CONSTRAINT constr_check depends on the TABLE: public.cities

ALTER TABLE public.cities_cd
	DROP CONSTRAINT constr_check;

ALTER TABLE public.cities_cd RENAME TO cities_cd_randomly_generated_part;

ALTER TABLE public.cities RENAME TO cities_randomly_generated_part;

CREATE TABLE public.measurement (
	id_key bigint,
	id bigint,
	city_id integer NOT NULL,
	logdate integer
)
PARTITION BY RANGE (logdate);

ALTER TABLE public.measurement OWNER TO khazieva_gr;

CREATE TABLE public.measurement_2 PARTITION OF public.measurement
FOR VALUES FROM (6) TO (10);

ALTER TABLE public.measurement_2 OWNER TO khazieva_gr;

CREATE TABLE public.measurement_1 PARTITION OF public.measurement
FOR VALUES FROM (1) TO (5);

ALTER TABLE public.measurement_1 OWNER TO khazieva_gr;

INSERT INTO public.measurement(id, city_id, logdate)
SELECT id, city_id, logdate FROM public.measurement_randomly_generated_part;

DROP TABLE public.measurement_1_randomly_generated_part;

DROP TABLE public.measurement_2_randomly_generated_part;

DROP TABLE public.measurement_randomly_generated_part;

CREATE TABLE public.cities (
	c0 integer,
	c1 integer,
	c2 text,
	c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.cities OWNER TO khazieva_gr;

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

INSERT INTO public.cities(c1, c2, c3)
SELECT c1, c2, c3 FROM public.cities_randomly_generated_part;

DROP TABLE public.cities56_randomly_generated_part;

DROP TABLE public.cities57_randomly_generated_part;

DROP TABLE public.cities_cd_10_to_100_randomly_generated_part;

DROP TABLE public.cities_cd_10_to_102_randomly_generated_part;

DROP TABLE public.cities_cd_10_to_103_randomly_generated_part;

DROP TABLE public.cities_cd_randomly_generated_part;

DROP TABLE public.towns_randomly_generated_part;

DROP TABLE public.cities_randomly_generated_part;

ALTER TABLE public.cities_cd
	ADD CONSTRAINT constr_check CHECK ((c1 > 5));