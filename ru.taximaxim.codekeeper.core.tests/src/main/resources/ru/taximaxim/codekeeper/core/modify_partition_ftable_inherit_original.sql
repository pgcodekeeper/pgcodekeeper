CREATE TABLE public.cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.cities OWNER TO galiev_mr;

CREATE TABLE public.new_cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE public.new_cities OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.cities_xz PARTITION OF public.cities
FOR VALUES IN ('x', 'z')
SERVER myserver;

ALTER FOREIGN TABLE ONLY public.cities_xz ALTER COLUMN c1 SET NOT NULL;

ALTER FOREIGN TABLE public.cities_xz OWNER TO galiev_mr;