SET search_path = pg_catalog;

-- DEPCY: This INDEX depends on the INDEX: test.the_part_2_c1_idx

DROP INDEX public.the_part_index_c1_idx;

CREATE INDEX the_part_2_c1_idx ON test.the_part_2 USING hash (c1);

CREATE INDEX the_part_index_c1_idx ON ONLY public.the_part USING hash (c1);