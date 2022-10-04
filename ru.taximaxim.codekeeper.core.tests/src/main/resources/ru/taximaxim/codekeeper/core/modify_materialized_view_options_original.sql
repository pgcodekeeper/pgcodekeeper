CREATE TABLE public.testtable (
    c1 integer NOT NULL,
    c2 text NOT NULL
);

CREATE MATERIALIZED VIEW public.testview 
WITH (fillfactor = '80', user_catalog_table = false)
AS SELECT * FROM public.testtable 
WITH NO DATA;
