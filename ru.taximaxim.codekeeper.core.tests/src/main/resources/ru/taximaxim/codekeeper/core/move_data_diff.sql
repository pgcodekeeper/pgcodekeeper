SET search_path = pg_catalog;

ALTER TABLE public.cities2 RENAME TO cities2_randomly_generated_part;

-- DEPCY: This SEQUENCE person_age_seq is a dependency of COLUMN: public.person.age

CREATE SEQUENCE public.person_age_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.person_age_seq OWNER TO khazieva_gr;

CREATE TABLE public.person (
	id bigint,
	age bigint DEFAULT nextval('public.person_age_seq'::regclass) NOT NULL
);

ALTER TABLE public.person OWNER TO khazieva_gr;

-- DEPCY: This VIEW v depends on the TABLE: public.tbl

DROP VIEW public.v;

-- DEPCY: This TRIGGER events_insert depends on the TABLE: public.tbl

DROP TRIGGER events_insert ON public.tbl;

-- DEPCY: This FUNCTION events_insert_trigger depends on the TABLE: public.tbl

DROP FUNCTION public.events_insert_trigger();

-- DEPCY: This CONSTRAINT tbl_pkey depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_pkey;

-- DEPCY: This CONSTRAINT tbl_event_time_check depends on the TABLE: public.tbl

ALTER TABLE public.tbl
	DROP CONSTRAINT tbl_event_time_check;

-- DEPCY: This RULE notify_me_tbl depends on the TABLE: public.tbl

DROP RULE notify_me_tbl ON public.tbl;

-- DEPCY: This INDEX tbl_idx depends on the TABLE: public.tbl

DROP INDEX public.tbl_idx;

ALTER TABLE public.tbl RENAME TO tbl_randomly_generated_part;

DROP SEQUENCE public.cities2_city_id_seq;

CREATE SEQUENCE public.cities2_city_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER SEQUENCE public.cities2_city_id_seq OWNER TO khazieva_gr;

CREATE TABLE public.cities2 (
	id1 text NOT NULL,
	id3 text NOT NULL,
	id text NOT NULL,
	city_id bigint DEFAULT nextval('public.cities2_city_id_seq'::regclass) NOT NULL,
	c_name text NOT NULL,
	population bigint
);

ALTER TABLE public.cities2 OWNER TO khazieva_gr;

INSERT INTO public.cities2(id1, id, city_id, c_name, population)
SELECT id1, id, city_id, c_name, population FROM public.cities2_randomly_generated_part;

DROP TABLE public.cities2_randomly_generated_part;

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

ALTER SEQUENCE public.person_age_seq
	OWNED BY public.person.age;

ALTER SEQUENCE public.cities2_city_id_seq
	OWNED BY public.cities2.city_id;