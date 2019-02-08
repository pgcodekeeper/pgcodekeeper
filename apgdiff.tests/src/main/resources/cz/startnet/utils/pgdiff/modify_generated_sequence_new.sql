CREATE TABLE public.testtable (
    id integer NOT NULL
);

ALTER TABLE public.testtable ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME changed_named_seq
    START WITH 5
    INCREMENT BY 12
    MINVALUE 5
    NO MAXVALUE
    CACHE 1
);