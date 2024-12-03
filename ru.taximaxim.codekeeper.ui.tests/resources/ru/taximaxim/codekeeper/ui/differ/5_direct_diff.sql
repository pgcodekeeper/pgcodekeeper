SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

-- DEPCY: This SCHEMA newschema is a dependency of VIEW: public.v1

CREATE SCHEMA newschema;

CREATE VIEW public.v1 AS
	SELECT t1.c1,
    t3.c2,
    t3.c3,
    t3.c4
   FROM public.t1, public.t3;