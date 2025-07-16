CREATE TABLE public.t1 (
    a circle,
    b circle
);

ALTER TABLE public.t1
	ADD CONSTRAINT c1 EXCLUDE USING gist (a WITH &&, b WITH &&);
	
CREATE TABLE public.testtable2 (
    col1 integer NOT NULL,
    col2 integer NOT NULL,
    col3 integer,
    col4 integer
);

-------------------------------------------------------------

ALTER TABLE public.testtable2
  ADD CONSTRAINT testtable4_pk PRIMARY KEY (col1, col2) INCLUDE (col3, col4);

CREATE TABLE public.testtable4 (
    col1 integer NOT NULL,
    col2 integer NOT NULL,
    col3 integer,
    col4 integer
);

-------------------------------------------------------------

ALTER TABLE public.testtable4
  ADD CONSTRAINT testtable4_pk PRIMARY KEY (col1, col2);
  
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
  ADD CONSTRAINT fk FOREIGN KEY (col1, col2) REFERENCES public.test_pk (col1, col2);
  
 CREATE TABLE public.test_fk_2 (
    col1 integer NOT NULL,
    col2 integer NOT NULL,
    col3 integer NOT NULL,
    col4 integer,
    col5 integer
);

--------------------------------------------------------------

ALTER TABLE public.test_fk_2
  ADD CONSTRAINT fk_2 FOREIGN KEY (col1, col2) REFERENCES public.test_pk (col1, col2);
  
 CREATE TABLE public.test_fk_3 (
    col1 integer NOT NULL,
    col2 integer NOT NULL,
    col3 integer NOT NULL,
    col4 integer,
    col5 integer
);

--------------------------------------------------------------

ALTER TABLE public.test_fk_3
  ADD CONSTRAINT fk_3 FOREIGN KEY (col1, col2) REFERENCES public.test_pk (col1, col2) ON DELETE SET NULL(col1, col2);
  