CREATE TABLE public.cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

CREATE TABLE public.cities_ab PARTITION OF public.cities
FOR VALUES IN ('a', 'b');
