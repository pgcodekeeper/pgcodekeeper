CREATE TABLE public.test (
    c1 integer,
    c2 integer,
    c3 integer,
    c4 text,
    c5 text,
    c6 text,
    c7 text
)
PARTITION BY RANGE (c1, c2);