SET search_path = pg_catalog;

CREATE OR REPLACE PROCEDURE public.insert_data(a integer, b integer)
    LANGUAGE sql
    AS $$
INSERT INTO tbl VALUES (a);
INSERT INTO tbl VALUES (b);
$$;

ALTER PROCEDURE public.insert_data(a integer, b integer) OWNER TO shamsutdinov_lr;