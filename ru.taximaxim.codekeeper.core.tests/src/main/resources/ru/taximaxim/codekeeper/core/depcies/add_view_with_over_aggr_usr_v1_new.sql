CREATE VIEW public.v1 AS
	SELECT enr.f_network_item5         
   FROM ( SELECT public.max(eni_c.link) AS f_network_item5
           FROM public.bug_table21 eni_c) enr;
