SET search_path = pg_catalog;

-- DEPCY: This VIEW v1 depends on the COLUMN: public.t1.id

DROP VIEW s.v1;

-- DEPCY: This VIEW v3 depends on the COLUMN: public.t1.id

DROP VIEW s.v3;

-- DEPCY: This VIEW v2 depends on the COLUMN: public.t1.id

DROP VIEW public.v2;

ALTER TABLE public.t1
	ALTER COLUMN id TYPE bigint USING id::bigint; /* TYPE change - table: public.t1 original: integer new: bigint */

CREATE VIEW s.v1 AS
	SELECT t1.id
   FROM public.t1;

ALTER VIEW s.v1 OWNER TO levsha_aa;

CREATE VIEW public.v2 AS
	SELECT t1.id
   FROM public.t1;

ALTER VIEW public.v2 OWNER TO levsha_aa;

CREATE VIEW s.v3 AS
	SELECT v2.id
   FROM public.v2;

ALTER VIEW s.v3 OWNER TO levsha_aa;