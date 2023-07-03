SET search_path = pg_catalog;

CREATE OR REPLACE PROCEDURE public.insert_data()
    LANGUAGE sql
    SET "DateStyle" TO 'postgres, dmy'
    AS $$
INSERT INTO tbl VALUES (111);
INSERT INTO tbl VALUES (222);
$$;

CREATE OR REPLACE PROCEDURE public.insert_data(a integer, b integer)
    LANGUAGE sql
    SET "DateStyle" TO 'postgres, dmy'
    AS $$
INSERT INTO tbl VALUES (a);
INSERT INTO tbl VALUES (b);
$$;
