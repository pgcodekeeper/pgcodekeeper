SET search_path = pg_catalog;

-- DEPCY: This AGGREGATE max is a dependency of VIEW: public.v2

CREATE AGGREGATE public.max(boolean) (
	SFUNC = text_larger,
	STYPE = boolean
);

CREATE VIEW public.v2 AS
	SELECT enr.f_network_item5         
   FROM ( SELECT public.max(eni_c.col1) AS f_network_item5
           FROM public.bug_table21 eni_c) enr;