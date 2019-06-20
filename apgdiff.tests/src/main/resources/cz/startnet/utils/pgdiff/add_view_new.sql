CREATE TABLE public.testtable (
    id bigint,
    name character varying(30)
);

ALTER TABLE public.testtable OWNER TO fordfrog;

CREATE VIEW public.testview AS
    SELECT testtable.id, testtable.name FROM public.testtable
WITH LOCAL CHECK OPTION;

ALTER TABLE public.testview OWNER TO fordfrog;