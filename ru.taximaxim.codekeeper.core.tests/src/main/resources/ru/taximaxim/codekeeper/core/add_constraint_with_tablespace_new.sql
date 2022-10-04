CREATE TABLE public.testtable (
    c1 integer,
    c2 integer,
    c3 text
);

SET default_tablespace = test_tablespace;

ALTER TABLE ONLY public.testtable
    ADD CONSTRAINT pk_testtable PRIMARY KEY (c1);

ALTER TABLE ONLY public.testtable
    ADD CONSTRAINT un_testtable UNIQUE (c3);
    
ALTER TABLE ONLY public.testtable
    ADD CONSTRAINT ex_testtable EXCLUDE USING gist (c2 WITH =, c3 WITH &&);
    
SET default_tablespace = '';