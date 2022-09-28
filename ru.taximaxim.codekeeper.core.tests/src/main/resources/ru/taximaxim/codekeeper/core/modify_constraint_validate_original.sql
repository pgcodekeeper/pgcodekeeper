CREATE DOMAIN public.dom1 AS integer;

ALTER DOMAIN public.dom1
    ADD CONSTRAINT dom1_check CHECK ((VALUE <> '-1'::integer)) NOT VALID;


CREATE TABLE public.t1 (
    c1 int
);

ALTER TABLE public.t1
    ADD CONSTRAINT t1_c1_check CHECK ((c1 <> '-1'::integer)) NOT VALID;