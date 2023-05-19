CREATE TABLE public.testtable (
    c1 integer NOT NULL,
    c2 text NOT NULL,
    c3 text
);

CREATE MATERIALIZED VIEW public.testview_1
TABLESPACE my_space AS
    SELECT * FROM public.testtable
WITH NO DATA;

CREATE MATERIALIZED VIEW public.testview_2 AS
    SELECT * FROM public.testtable
WITH NO DATA;

CREATE MATERIALIZED VIEW public.testview_3 AS
	SELECT * FROM public.testtable
WITH DATA DISTRIBUTED RANDOMLY;