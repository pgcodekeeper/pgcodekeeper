SET search_path = pg_catalog;

-- DEPCY: This VIEW v1 depends on the TYPE: public.ty1

DROP VIEW public.v1;

-- DEPCY: This COLUMN c1 depends on the TYPE: public.ty1

ALTER TABLE ONLY public.t1
	DROP COLUMN c1;

DROP TYPE public.ty1;

CREATE TYPE public.ty1 AS ENUM (
	'a'
);

ALTER TYPE public.ty1 OWNER TO botov_av;

ALTER TABLE public.t1
	ADD COLUMN c1 public.ty1;

CREATE VIEW public.v1 AS
	SELECT t1.c1
   FROM public.t1;

ALTER VIEW public.v1 OWNER TO botov_av;