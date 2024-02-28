CREATE TABLE public.temp_test_1 (
    id integer,
    column1 int
);

CREATE TABLE public.temp_test (
    id integer NOT NULL,
    column1 integer
);

-- add constraint with pk
ALTER TABLE public.temp_test
    ADD CONSTRAINT temp_test_pkey PRIMARY KEY (id);

-- add constraint with fk
ALTER TABLE public.temp_test
    ADD CONSTRAINT fk_test FOREIGN KEY (column1) REFERENCES public.temp_test_fk(id) DEFERRABLE;

-- add constraint with check
CREATE TABLE public.partitioned (
    a int,
    CONSTRAINT check_a CHECK (a > 0)
) PARTITION BY RANGE (a);

-- add constraint with EXCLUDE
CREATE TABLE public.t11 (
    a circle,
    b circle
);

ALTER TABLE public.t11
    ADD CONSTRAINT c1 EXCLUDE USING gist (a WITH &&, b WITH &&);
    
-- add constraint with PK and UNIQUE
CREATE TABLE public.testtable (
    c1 integer,
    c2 integer,
    c3 text
);

ALTER TABLE ONLY public.testtable
    ADD CONSTRAINT pk_testtable PRIMARY KEY (c1);

ALTER TABLE ONLY public.testtable
    ADD CONSTRAINT un_testtable UNIQUE (c3);