SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD CONSTRAINT pk_testtable PRIMARY KEY (c1)
	USING INDEX TABLESPACE test_tablespace;

ALTER TABLE public.testtable
	ADD CONSTRAINT un_testtable UNIQUE (c3)
	USING INDEX TABLESPACE test_tablespace;

ALTER TABLE public.testtable
	ADD CONSTRAINT ex_testtable EXCLUDE USING gist (c2 WITH =, c3 WITH &&)
	USING INDEX TABLESPACE test_tablespace;
