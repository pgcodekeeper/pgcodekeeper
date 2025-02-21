SET search_path = pg_catalog;

-- HIDDEN: Object test.the_part_2_c1_idx of type INDEX (action: DROP, reason: object cannot be dropped)

-- DEPCY: This INDEX the_part_index_c1_idx depends on the INDEX: test.the_part_2_c1_idx

DROP INDEX public.the_part_index_c1_idx;

-- HIDDEN: Object test.the_part_3_c1_idx of type INDEX (action: DROP, reason: object cannot be dropped)

CREATE INDEX the_part_2_c1_idx ON test.the_part_2 USING hash (c1);

CREATE INDEX the_part_index_c1_idx ON ONLY public.the_part USING hash (c1);

CREATE INDEX IF NOT EXISTS the_part_3_c1_idx ON test.the_part_3 USING hash (c1);

ALTER INDEX public.the_part_index_c1_idx ATTACH PARTITION test.the_part_3_c1_idx;