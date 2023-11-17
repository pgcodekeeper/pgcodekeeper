SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD CONSTRAINT field4check CHECK (((field4 > (-5.0)::double precision) AND (field4 < (5.0)::double precision)));

ALTER TABLE public.test_un
	ADD CONSTRAINT con_col1 UNIQUE (col1) INCLUDE (col1) WITH (fillfactor='10');
