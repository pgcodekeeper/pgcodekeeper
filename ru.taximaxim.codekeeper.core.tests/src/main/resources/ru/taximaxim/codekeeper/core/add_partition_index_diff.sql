SET search_path = pg_catalog;

CREATE INDEX test_index ON ONLY public.test USING btree (c3, c4 DESC) INCLUDE (c5, c6, c7);