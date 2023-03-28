CREATE SCHEMA test;

CREATE TABLE public.the_part (
    c1 integer,
    c2 text
)
PARTITION BY RANGE (c1);

CREATE TABLE test.the_part_2 
PARTITION OF public.the_part
FOR VALUES FROM (11) TO (20);

CREATE TABLE test.the_part_3 
PARTITION OF public.the_part
FOR VALUES FROM (11) TO (20);

CREATE INDEX the_part_index_c1_idx ON ONLY public.the_part USING hash (c1);

CREATE INDEX the_part_2_c1_idx ON test.the_part_2 USING hash (c1);

CREATE INDEX the_part_3_c1_idx ON test.the_part_3 USING hash (c1);

ALTER INDEX public.the_part_index_c1_idx ATTACH PARTITION test.the_part_3_c1_idx;
