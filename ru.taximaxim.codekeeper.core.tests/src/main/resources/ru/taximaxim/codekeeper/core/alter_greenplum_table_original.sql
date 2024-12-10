CREATE TABLE public.test1 (
    col1 integer
)
DISTRIBUTED BY (col1);

CREATE TABLE public.test2 (
    col1 integer,
    col2 integer
)
DISTRIBUTED BY (col2);