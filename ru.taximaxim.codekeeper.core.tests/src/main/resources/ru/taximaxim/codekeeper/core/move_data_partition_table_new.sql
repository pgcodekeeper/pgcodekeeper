CREATE TABLE public.measurement (
    id_key bigint,
    id bigint,
    city_id integer NOT NULL,
    logdate integer
)
PARTITION BY RANGE (logdate); 

ALTER TABLE public.measurement OWNER TO khazieva_gr;

CREATE TABLE public.measurement_1 PARTITION OF public.measurement
FOR VALUES FROM (1) TO (5);

ALTER TABLE public.measurement_1 OWNER TO khazieva_gr; 

CREATE TABLE public.measurement_2 PARTITION OF public.measurement
FOR VALUES FROM (6) TO (10);

ALTER TABLE public.measurement_2 OWNER TO khazieva_gr;

--------------------------------------------------------------------------------

CREATE TABLE public.cities (
    c0 integer,
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
--child of child {cities -> cities_cd -> cities_cd_10_to_102}
CREATE TABLE public.cities_cd_10_to_102 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities_cd_10_to_102 OWNER TO khazieva_gr;

CREATE TABLE public.cities_cd_10_to_103 PARTITION OF public.cities_cd
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities_cd_10_to_103 OWNER TO khazieva_gr;
----------------------------------------------------------------
--child of child  of child  {cities -> cities_cd -> cities_cd_10_to_100 -> public.cities56}
CREATE TABLE public.cities56 PARTITION OF public.cities_cd_10_to_100
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities56 OWNER TO khazieva_gr;

CREATE TABLE public.cities57 PARTITION OF public.cities_cd_10_to_100
FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities57 OWNER TO khazieva_gr;
