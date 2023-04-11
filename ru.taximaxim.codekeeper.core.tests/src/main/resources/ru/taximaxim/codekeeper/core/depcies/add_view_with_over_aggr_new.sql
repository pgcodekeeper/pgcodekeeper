CREATE TABLE public.bug_table21 (
    link uuid NOT NULL,
    col1 boolean,
    col2 integer,
    f_network_pts_types smallint NOT NULL
);

ALTER TABLE public.bug_table21
    ADD CONSTRAINT bug_table21_pkey PRIMARY KEY (link);
    
----------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION public.testfunction(uuid) RETURNS text
    LANGUAGE plpgsql
    AS $$
BEGIN
	RETURN 'test'::text;
END;
$$;

CREATE AGGREGATE public.max(uuid) (
    SFUNC = text_larger,
    STYPE = uuid,
    FINALFUNC = public.testfunction -- return type: text
);

CREATE OR REPLACE FUNCTION public.testfunction(text) RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
	RETURN 15;
END;
$$;

CREATE AGGREGATE public.max(text) (
    SFUNC = text_larger,
    STYPE = text,
    FINALFUNC = public.testfunction -- return type: integer
);

CREATE VIEW public.v1 AS
    SELECT enr.f_network_item5         
   FROM ( SELECT public.max(eni_c.link) AS f_network_item5
           FROM public.bug_table21 eni_c) enr;

----------------------------------------------------------------------------------------------

CREATE AGGREGATE public.max(integer) (
    SFUNC = text_larger,
    STYPE = integer -- return type: integer
);

CREATE AGGREGATE public.max(boolean) (
    SFUNC = text_larger,
    STYPE = boolean -- return type: boolean
);
           
CREATE VIEW public.v2 AS
    SELECT enr.f_network_item5         
   FROM ( SELECT public.max(eni_c.col1) AS f_network_item5
           FROM public.bug_table21 eni_c) enr;
