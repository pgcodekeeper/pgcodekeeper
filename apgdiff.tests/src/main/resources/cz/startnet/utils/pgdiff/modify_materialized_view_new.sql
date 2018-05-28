CREATE TABLE public.testtable (
    c1 integer NOT NULL,
    c2 text NOT NULL,
    c3 text
);

ALTER TABLE public.testtable OWNER TO galiev_mr;

CREATE MATERIALIZED VIEW public.testview_1 
TABLESPACE my_space AS
    SELECT * FROM public.testtable
WITH DATA;

ALTER MATERIALIZED VIEW public.testview_1 OWNER TO galiev_mr;

CREATE MATERIALIZED VIEW public.testview_2
TABLESPACE my_space AS
    SELECT * FROM public.testtable
WITH NO DATA;

ALTER MATERIALIZED VIEW public.testview_2 OWNER TO galiev_mr;