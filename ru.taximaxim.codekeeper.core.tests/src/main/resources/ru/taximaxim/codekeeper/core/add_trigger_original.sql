CREATE TABLE public.test_table (
    id serial NOT NULL,
    "BALANCE" integer
);

CREATE VIEW public.test_view AS 
    SELECT test_table.id FROM public.test_table;