SET search_path = pg_catalog;

DROP PROCEDURE public.insert_data(a integer, b integer);

CREATE OR REPLACE PROCEDURE public.insert_data(a integer)
    LANGUAGE sql
    AS $$
INSERT INTO tbl VALUES (a);
$$;

ALTER PROCEDURE public.insert_data(a integer) OWNER TO shamsutdinov_lr;