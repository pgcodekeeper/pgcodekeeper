CREATE TABLE public.t1 (
    c1 integer
);

CREATE SEQUENCE public.s1
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.t1 ALTER COLUMN c1 SET DEFAULT nextval('public.s1'::regclass);

GRANT ALL ON SCHEMA public TO maindb;