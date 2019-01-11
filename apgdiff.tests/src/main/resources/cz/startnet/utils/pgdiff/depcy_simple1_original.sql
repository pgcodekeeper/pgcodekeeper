CREATE SCHEMA s;

ALTER SCHEMA s OWNER TO levsha_aa;

CREATE TABLE public.t1 (
    id integer
);

ALTER TABLE public.t1 OWNER TO levsha_aa;

CREATE VIEW public.v2 AS
 SELECT t1.id,
    'qwe' AS c1
   FROM public.t1;

ALTER TABLE public.v2 OWNER TO levsha_aa;

CREATE VIEW s.v1 AS
 SELECT t1.id
   FROM public.t1;

ALTER TABLE s.v1 OWNER TO levsha_aa;

CREATE VIEW s.v3 AS
 SELECT v2.id
   FROM public.v2;

ALTER TABLE s.v3 OWNER TO levsha_aa;