SET search_path = pg_catalog;

CREATE OR REPLACE PROCEDURE public.insert_data()
    LANGUAGE sql
    AS $$
INSERT INTO tbl VALUES (555);
$$;

ALTER PROCEDURE public.insert_data() OWNER TO shamsutdinov_lr;