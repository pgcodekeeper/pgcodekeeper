SET search_path = pg_catalog;

ALTER TABLE public.testtable
	DROP CONSTRAINT field4check;

ALTER TABLE public.testtable
	ADD CONSTRAINT field4check CHECK ((field4 > (0.0)::double precision));
