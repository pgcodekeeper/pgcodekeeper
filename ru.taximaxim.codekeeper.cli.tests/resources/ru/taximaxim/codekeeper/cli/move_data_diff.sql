SET search_path = pg_catalog;

DROP TABLE public.cities_fg;

DROP TABLE public.cities_4544;

-- DEPCY: This VIEW depends on the TABLE: public.tbl

DROP VIEW public.v;

-- DEPCY: This TRIGGER depends on the TABLE: public.tbl

DROP TRIGGER events_insert ON public.tbl;

-- DEPCY: This FUNCTION depends on the TABLE: public.tbl

DROP FUNCTION public.events_insert_trigger();

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_pkey;

-- DEPCY: This CONSTRAINT depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_event_time_check;

-- DEPCY: This RULE depends on the TABLE: public.tbl

DROP RULE notify_me_tbl ON public.tbl;

-- DEPCY: This INDEX depends on the TABLE: public.tbl

DROP INDEX public.tbl_idx;

ALTER TABLE public.tbl RENAME TO tbl_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.measurement

ALTER TABLE public.measurement_2 RENAME TO measurement_2_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.measurement

ALTER TABLE public.measurement_1 RENAME TO measurement_1_randomly_generated_part;

ALTER TABLE public.measurement RENAME TO measurement_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.cities

ALTER TABLE public.towns RENAME TO towns_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.cities

ALTER TABLE public.cities_cd_10_to_103 RENAME TO cities_cd_10_to_103_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.cities

ALTER TABLE public.cities_cd_10_to_102 RENAME TO cities_cd_10_to_102_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.cities

ALTER TABLE public.cities57 RENAME TO cities57_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.cities

ALTER TABLE public.cities56 RENAME TO cities56_randomly_generated_part;

-- DEPCY: This TABLE depends on the TABLE: public.cities

ALTER TABLE public.cities_cd_10_to_100 RENAME TO cities_cd_10_to_100_randomly_generated_part;

-- DEPCY: This CONSTRAINT depends on the TABLE: public.cities

ALTER TABLE public.cities_cd
	DROP CONSTRAINT constr_check;

-- DEPCY: This TABLE depends on the TABLE: public.cities

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

CREATE TABLE public.tbl (
	id bigint DEFAULT nextval('public.seq_tbl_id'::regclass) NOT NULL,
	id_2 bigint DEFAULT nextval('public.seq_tbl_id_2'::regclass) NOT NULL,
	name text,
	population double precision,
	description integer DEFAULT 55777,
	altitude text DEFAULT '23'::text,
	event_time timestamp without time zone DEFAULT now() NOT NULL
);

GRANT INSERT ON TABLE public.tbl TO test_user;

INSERT INTO public.tbl(id, id_2, name, population, description, altitude, event_time)
SELECT id, id_2, name, population, description, altitude, event_time FROM public.tbl_randomly_generated_part;

DROP TABLE public.tbl_randomly_generated_part;

CREATE VIEW public.v AS
	SELECT tbl.name,
    tbl.altitude,
    1 AS qwerty
   FROM public.tbl;

-- DEPCY: This FUNCTION is a dependency of TRIGGER: public.tbl.events_insert

CREATE OR REPLACE FUNCTION public.events_insert_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  UPDATE public.tbl
  SET description = (SELECT trunc(random() * 100 + 1)) 
  WHERE id_2 = 2;
  RETURN NULL;
END;
$$;

CREATE TRIGGER events_insert
	AFTER INSERT ON public.tbl
	FOR EACH ROW
	EXECUTE PROCEDURE public.events_insert_trigger();

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_pkey PRIMARY KEY (id);

ALTER TABLE public.tbl
	ADD CONSTRAINT tbl_event_time_check CHECK (((event_time >= '2020-01-01 00:00:00'::timestamp without time zone) AND (event_time < '2021-01-01 00:00:00'::timestamp without time zone)));

CREATE RULE notify_me_tbl AS
    ON DELETE TO public.tbl DO  NOTIFY tbl;

CREATE INDEX tbl_idx ON public.tbl USING btree (event_time);

-- DEPCY: This TABLE is a dependency of TABLE: public.cities_cd_10_to_103

-- DEPCY: This TABLE is a dependency of TABLE: public.cities57

ALTER TABLE public.cities_cd
	ADD CONSTRAINT constr_check CHECK ((c1 > 5));
