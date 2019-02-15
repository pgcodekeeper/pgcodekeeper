CREATE TABLE public.test_table (
    id serial NOT NULL
);

ALTER TABLE public.test_table OWNER TO fordfrog;

ALTER TABLE ONLY public.test_table
    ADD CONSTRAINT test_table_pkey PRIMARY KEY (id);