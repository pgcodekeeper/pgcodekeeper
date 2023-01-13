COMMENT ON SCHEMA public IS 'Standard public schema';

CREATE TABLE public.tbl (
    name integer
);

CREATE VIEW public.v1 AS
    SELECT a.name,
    1 AS qwe
   FROM public.tbl a;

CREATE VIEW public.v2 AS
    SELECT a.name,
    2 AS zxc
   FROM public.v1 a;

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;