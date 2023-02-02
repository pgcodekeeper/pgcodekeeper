COMMENT ON SCHEMA public IS 'Standard public schema';


CREATE SEQUENCE public.seq_tbl_id
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

CREATE SEQUENCE public.seq_tbl_id_2
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;



CREATE TABLE public.tbl (
    id bigint DEFAULT nextval('public.seq_tbl_id'::regclass) NOT NULL,
    id_2 bigint DEFAULT nextval('public.seq_tbl_id_2'::regclass) NOT NULL,
    name text,
    population double precision,
    altitude text DEFAULT '23'::text,
    description integer DEFAULT 55777,
    event_time timestamp without time zone DEFAULT now() NOT NULL
);

GRANT INSERT ON TABLE public.tbl TO test_user;

--------------------------------------------------------------------------------

CREATE INDEX tbl_idx ON public.tbl USING btree (event_time);

--------------------------------------------------------------------------------

CREATE RULE notify_me_tbl AS
    ON DELETE TO public.tbl
  DO ALSO NOTIFY tbl;

--------------------------------------------------------------------------------

ALTER TABLE public.tbl
    ADD CONSTRAINT tbl_event_time_check CHECK (((event_time >= '2020-01-01 00:00:00'::timestamp without time zone) AND (event_time < '2021-01-01 00:00:00'::timestamp without time zone)));
    
--------------------------------------------------------------------------------

ALTER TABLE public.tbl
    ADD CONSTRAINT tbl_pkey PRIMARY KEY (id);



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

CREATE VIEW public.v AS
    SELECT tbl.name,
    tbl.altitude,
    1 AS qwerty
   FROM public.tbl;


REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

--------------------------------------------------------------------------------

CREATE TABLE public.measurement (
    id bigint,
    city_id integer NOT NULL,
    logdate integer
)
PARTITION BY RANGE (logdate); 

ALTER TABLE public.measurement OWNER TO khazieva_gr;

CREATE TABLE public.measurement_1 PARTITION OF public.measurement
FOR VALUES FROM (1) TO (4);

ALTER TABLE public.measurement_1 OWNER TO khazieva_gr; 

CREATE TABLE public.measurement_2 PARTITION OF public.measurement
FOR VALUES FROM (6) TO (10);

ALTER TABLE public.measurement_2 OWNER TO khazieva_gr;

--------------------------------------------------------------------------------

CREATE TABLE public.cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.cities OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd PARTITION OF public.cities (
    CONSTRAINT constr_check CHECK ((c1 > 5))
)
FOR VALUES IN ('c', 'd')
PARTITION BY RANGE (c3);

ALTER TABLE public.cities_cd OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd_10_to_100 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('100')
PARTITION BY RANGE (c3);

ALTER TABLE public.cities_cd_10_to_100 OWNER TO khazieva_gr;

CREATE TABLE public.towns PARTITION OF public.cities
FOR VALUES FROM ('1') TO ('100');

ALTER TABLE public.towns OWNER TO khazieva_gr;
----------------------------------------------------------------
CREATE TABLE public.cities_cd_10_to_102 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities_cd_10_to_102 OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd_10_to_103 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities_cd_10_to_103 OWNER TO khazieva_gr;
----------------------------------------------------------------
CREATE TABLE public.cities56 PARTITION OF public.cities_cd_10_to_100
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities56 OWNER TO khazieva_gr;

CREATE TABLE public.cities57 PARTITION OF public.cities_cd_10_to_100
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities57 OWNER TO khazieva_gr;
-----------------------------------------------------------------
CREATE TABLE public.cities_fg PARTITION OF public.cities
FOR VALUES IN ('f', 'g');

ALTER TABLE public.cities_fg OWNER TO khazieva_gr;

CREATE TABLE public.cities_4544 PARTITION OF public.cities
FOR VALUES IN ('f', 'g');

ALTER TABLE public.cities_4544 OWNER TO khazieva_gr;
----------------------------------------------------------------