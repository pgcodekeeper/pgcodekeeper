CREATE OR REPLACE FUNCTION public.my_method(internal) RETURNS table_am_handler
    LANGUAGE internal STRICT PARALLEL SAFE
    AS $$heap_tableam_handler$$;

CREATE ACCESS METHOD my_method TYPE TABLE HANDLER public.my_method;


-- Test group I (simple tables)

CREATE TABLE public.t01 (
    c1 integer,
    c2 character varying(40),
    c3 text
);

CREATE TABLE public.t02 (
    c1 integer,
    c2 character varying(40),
    c3 text
) USING heap;

CREATE TABLE public.t03 (
    c1 integer,
    c2 character varying(40),
    c3 text
) USING my_method;


-- Test group II (table of type)

CREATE TYPE public.employee_type AS (
    name text,
    salary numeric
);

CREATE TABLE public.employees OF public.employee_type (
    name WITH OPTIONS NOT NULL,
    salary WITH OPTIONS DEFAULT 1000
)
USING my_method;

ALTER TABLE public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (name);


-- Test group III (partitional tables)

CREATE TABLE public.measurement_year_month (
    logdate date NOT NULL,
    peaktemp integer,
    unitsales integer
)
PARTITION BY RANGE (date_part('year'::text, logdate), date_part('month'::text, logdate));

CREATE TABLE public.measurement_ym_older PARTITION OF public.measurement_year_month
FOR VALUES FROM (MINVALUE, MINVALUE) TO ('2016', '11')
USING my_method;

CREATE TABLE public.measurement_ym_y2016m11 PARTITION OF public.measurement_year_month
FOR VALUES FROM ('2016', '11') TO ('2016', '12');

CREATE TABLE public.measurement_ym_y2016m12 PARTITION OF public.measurement_year_month
FOR VALUES FROM ('2016', '12') TO ('2017', '1')
USING heap;


-- Test group IV

SET default_table_access_method = my_method;

CREATE TABLE public.t11 (
    c1 integer
);