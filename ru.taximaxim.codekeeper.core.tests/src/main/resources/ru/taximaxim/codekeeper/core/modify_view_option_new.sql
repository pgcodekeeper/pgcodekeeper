CREATE TABLE public.testtable (
    id bigint,
    name character varying(30)
);

CREATE VIEW public.testview AS
    SELECT testtable.id, testtable.name FROM public.testtable
    WITH LOCAL CHECK OPTION;