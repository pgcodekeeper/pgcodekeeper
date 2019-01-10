CREATE TABLE public.testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);


ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE UNIQUE INDEX testindex ON public.testtable USING btree (field1);

CREATE TABLE public.testtable_2 (
    field1 integer,
    field2 integer,
    field4 double precision
);

ALTER TABLE ONLY public.testtable_2
    ADD CONSTRAINT testtable_2_c2_fkey FOREIGN KEY (field2) REFERENCES public.testtable(field1);