CREATE TABLE public.test_table (
    c1 integer,
    c2 text
);

ALTER TABLE public.test_table
    ADD CONSTRAINT test_constraint EXCLUDE USING gist (public.test_function() WITH &&)
    USING INDEX TABLESPACE test_tablespace WHERE ((c1 <> 0)) DEFERRABLE INITIALLY DEFERRED;