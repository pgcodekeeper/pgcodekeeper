SET search_path = pg_catalog;

-- DEPCY: This FUNCTION testfunction is a dependency of VIEW: public.v1

CREATE OR REPLACE FUNCTION public.testfunction(uuid) RETURNS text
    LANGUAGE plpgsql
    AS $$
BEGIN
	RETURN 'test'::text;
END;
$$;

-- DEPCY: This AGGREGATE max is a dependency of VIEW: public.v1

CREATE AGGREGATE public.max(uuid) (
	SFUNC = text_larger,
	STYPE = uuid,
	FINALFUNC = public.testfunction
);

CREATE VIEW public.v1 AS
	SELECT enr.f_network_item5         
   FROM ( SELECT public.max(eni_c.link) AS f_network_item5
           FROM public.bug_table21 eni_c) enr;