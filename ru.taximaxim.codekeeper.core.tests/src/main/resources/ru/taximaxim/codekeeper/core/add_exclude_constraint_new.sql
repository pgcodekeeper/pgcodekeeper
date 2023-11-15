CREATE EXTENSION intarray SCHEMA public;

CREATE TABLE public.tt1 (
    c int[],
    EXCLUDE USING gist (c gist__intbig_ops  WITH &&)
);

CREATE TABLE public.testtable (
    id bigint NOT NULL,
    c circle,
    d_date_begin timestamptz,
    d_date_end timestamptz
);

ALTER TABLE public.testtable
    ADD CONSTRAINT testtable2_c_excl EXCLUDE (c DESC NULLS FIRST WITH &&) INCLUDE (id);

ALTER TABLE public.testtable
    ADD CONSTRAINT test EXCLUDE USING test (id DESC NULLS LAST WITH =) WITH (FILLFACTOR = 10) INITIALLY DEFERRED;

ALTER TABLE public.testtable
    ADD CONSTRAINT test2 EXCLUDE USING gist (id WITH =, daterange(d_date_begin, d_date_end, '[)'::TEXT) WITH &&)
    USING INDEX TABLESPACE ts_indexes DEFERRABLE INITIALLY DEFERRED;
    
ALTER TABLE public.testtable
    ADD CONSTRAINT test3 EXCLUDE ((id > 10) DESC NULLS LAST WITH =) WITH (deduplicate_items) INITIALLY DEFERRED;
