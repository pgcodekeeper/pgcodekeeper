CREATE TABLE public.testtable (
    id bigint NOT NULL,
    c circle,
    d_date_begin timestamptz,
    d_date_end timestamptz
);

ALTER TABLE public.testtable
    ADD CONSTRAINT testtable2_c_excl EXCLUDE USING gist (c WITH &&);

ALTER TABLE public.testtable
    ADD CONSTRAINT test EXCLUDE USING test (id WITH =) INITIALLY DEFERRED;

ALTER TABLE public.testtable
    ADD CONSTRAINT test2 EXCLUDE USING gist (id WITH =, daterange(d_date_begin, d_date_end, '[)'::TEXT) WITH &&)
    USING INDEX TABLESPACE ts_indexes DEFERRABLE INITIALLY DEFERRED;