CREATE VIEW public.v2 AS
SELECT ('public.foo'::regproc)::text AS text
UNION (
    SELECT ('public.goo(integer)'::regprocedure)::text AS text
    UNION ALL
    SELECT ('test'::regnamespace)::text AS text
);