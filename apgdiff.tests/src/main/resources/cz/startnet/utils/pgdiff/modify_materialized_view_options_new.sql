CREATE TABLE public.testtable (
    c1 integer NOT NULL,
    c2 text NOT NULL
);

CREATE MATERIALIZED VIEW public.testview 
WITH (fillfactor = '70', user_catalog_table)
AS SELECT * FROM public.testtable 
WITH NO DATA;
