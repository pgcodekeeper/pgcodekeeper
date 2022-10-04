SET search_path = pg_catalog;

ALTER TABLE public.testtable
	ADD CONSTRAINT field4check CHECK (((field4 > (-5.0)::double precision) AND (field4 < (5.0)::double precision)));
