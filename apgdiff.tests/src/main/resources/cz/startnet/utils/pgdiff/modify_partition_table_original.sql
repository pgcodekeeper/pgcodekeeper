CREATE EXTENSION IF NOT EXISTS postgres_fdw WITH SCHEMA public;

COMMENT ON EXTENSION postgres_fdw IS 'foreign-data wrapper for remote PostgreSQL servers';

CREATE TYPE public.comp AS (
    f1 integer,
    f2 text,
    f3 bigint
);

ALTER TYPE public.comp OWNER TO galiev_mr;

CREATE SERVER myserver FOREIGN DATA WRAPPER postgres_fdw OPTIONS (
    dbname 'foodb',
    host 'localhost',
    port '5432'
);

ALTER SERVER myserver OWNER TO galiev_mr;

CREATE TABLE public.cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));


ALTER TABLE public.cities OWNER TO galiev_mr;

CREATE TABLE public.cities_ab PARTITION OF public.cities (
    CONSTRAINT constr_check CHECK ((c1 > 5))
)
FOR VALUES IN ('a', 'b');


ALTER TABLE public.cities_ab OWNER TO galiev_mr;

CREATE TABLE public.cities_cd PARTITION OF public.cities (
    CONSTRAINT constr_check CHECK ((c1 > 5))
)
FOR VALUES IN ('c', 'd')
PARTITION BY RANGE (c3);


ALTER TABLE public.cities_cd OWNER TO galiev_mr;

CREATE TABLE public.cities_cd_10_to_100 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('100');

ALTER TABLE public.cities_cd_10_to_100 OWNER TO galiev_mr;

CREATE TABLE public.cities_fg PARTITION OF public.cities
FOR VALUES IN ('f', 'g');


ALTER TABLE public.cities_fg OWNER TO galiev_mr;

CREATE TABLE public.cities_hi PARTITION OF public.cities
FOR VALUES IN ('h', 'i');


ALTER TABLE public.cities_hi OWNER TO galiev_mr;

CREATE TABLE public.cities_mz PARTITION OF public.cities
FOR VALUES IN ('m', 'z');
ALTER TABLE ONLY public.cities_mz ALTER COLUMN c2 SET NOT NULL;


ALTER TABLE public.cities_mz OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.f_cities_e PARTITION OF public.cities
FOR VALUES IN ('e')
SERVER myserver;


ALTER FOREIGN TABLE public.f_cities_e OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.ftable (
    code integer NOT NULL
)
SERVER myserver;
ALTER TABLE ONLY public.ftable ALTER COLUMN code SET (n_distinct_inherited=1, n_distinct=-0.7);

ALTER TABLE ONLY public.ftable SET WITH OIDS;


ALTER FOREIGN TABLE public.ftable OWNER TO galiev_mr;

CREATE TABLE public.tab_of_type OF public.comp (
    f1 NOT NULL,
    f2 DEFAULT 'text'::text,
    CONSTRAINT tab_of_type_f3_check CHECK ((f3 > 0))
)
PARTITION BY LIST ("left"(lower(f2), 1));

ALTER TABLE public.tab_of_type OWNER TO galiev_mr;