CREATE TABLE public.testtable (
    id bigserial NOT NULL
);

ALTER TABLE public.testtable ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME custom_named_seq
    START WITH 1
    INCREMENT BY 2
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);