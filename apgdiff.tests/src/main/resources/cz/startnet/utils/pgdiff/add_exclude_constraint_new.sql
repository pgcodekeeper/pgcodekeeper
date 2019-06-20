CREATE TABLE public.testtable (
    id bigint NOT NULL,
    firstname character varying(30),
    c circle
);

ALTER TABLE public.testtable
    ADD CONSTRAINT testtable2_c_excl EXCLUDE USING gist (c WITH &&);

ALTER TABLE public.testtable
    ADD CONSTRAINT test EXCLUDE USING id(test WITH =) INITIALLY DEFERRED;