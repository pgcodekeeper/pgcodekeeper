CREATE SEQUENCE public.cities_city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

--------------------------------------------------------------------------------

CREATE TABLE public.cities (
    city_id bigint DEFAULT nextval('public.cities_city_id_seq'::regclass) NOT NULL,
    name text NOT NULL,
    population bigint
)
PARTITION BY LIST ("left"(lower(name), 1));

--------------------------------------------------------------------------------

CREATE TABLE public.cities_partdef PARTITION OF public.cities
DEFAULT;

ALTER TABLE ONLY public.cities_partdef ALTER COLUMN city_id SET DEFAULT nextval('public.cities_city_id_seq'::regclass);

--------------------------------------------------------------------------------

CREATE TABLE public.cities_ab PARTITION OF public.cities
FOR VALUES IN ('a', 'b')
PARTITION BY RANGE (population);

ALTER TABLE ONLY public.cities_ab ALTER COLUMN city_id SET DEFAULT nextval('public.cities_city_id_seq'::regclass);

ALTER TABLE public.cities_ab
    ADD CONSTRAINT city_id_nonzero CHECK ((city_id <> 0));

--------------------------------------------------------------------------------

CREATE TABLE public.cities_ab_10000_to_100000 PARTITION OF public.cities_ab
FOR VALUES FROM ('10000') TO ('100000');

ALTER TABLE ONLY public.cities_ab_10000_to_100000 ALTER COLUMN city_id SET DEFAULT nextval('public.cities_city_id_seq'::regclass);
