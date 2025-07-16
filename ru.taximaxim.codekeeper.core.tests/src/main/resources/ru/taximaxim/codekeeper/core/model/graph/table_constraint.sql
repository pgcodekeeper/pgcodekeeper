CREATE TABLE public.test_pk (
    col1 integer NOT NULL,
    col2 integer NOT NULL,
    col3 integer,
    col4 integer
);

-------------------------------------------------------------

ALTER TABLE public.test_pk
  ADD CONSTRAINT test_pk_pk PRIMARY KEY (col1, col2);

CREATE TABLE public.test_fk_1 (
    col1 integer NOT NULL,
    col2 integer NOT NULL,
    col3 integer NOT NULL,
    col4 integer,
    col5 integer
);

--------------------------------------------------------------

ALTER TABLE public.test_fk_1
  ADD CONSTRAINT fk FOREIGN KEY (col1, col2) REFERENCES public.test_pk (col2, col1);