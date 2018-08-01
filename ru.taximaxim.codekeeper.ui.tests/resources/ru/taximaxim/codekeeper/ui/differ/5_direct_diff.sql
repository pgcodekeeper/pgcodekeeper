SET TIMEZONE TO 'UTC';

SET search_path = pg_catalog;

-- DEPCY: This SCHEMA is a dependency of VIEW: public.v1

CREATE SCHEMA newschema;

ALTER SCHEMA newschema OWNER TO galiev_mr;

CREATE VIEW public.v1 AS
	SELECT t1.c1,
    t3.c2,
    t3.c3,
    t3.c4
   FROM public.t1, public.t3;

ALTER VIEW public.v1 OWNER TO galiev_mr;
