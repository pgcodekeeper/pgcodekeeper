SET search_path = pg_catalog;

-- DEPCY: This VIEW v3 depends on the VIEW: public.v2

DROP VIEW s.v3;

DROP VIEW public.v2;

CREATE VIEW public.v2 AS
	SELECT t1.id,
    'qwe' AS c1
   FROM public.t1;

ALTER VIEW public.v2 OWNER TO levsha_aa;

CREATE VIEW s.v3 AS
	SELECT v2.id
   FROM public.v2;

ALTER VIEW s.v3 OWNER TO levsha_aa;