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

CREATE INDEX test_index ON public.test 
USING btree (c3, c4 DESC) 
INCLUDE (c5, c6, c7);