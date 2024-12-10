SET search_path = pg_catalog;

DROP TABLE public.t01;

DROP TABLE public.t03;

-- DEPCY: This CONSTRAINT employees_pkey depends on the TABLE: public.employees

ALTER TABLE public.employees
	DROP CONSTRAINT employees_pkey;

DROP TABLE public.employees;

DROP TABLE public.measurement_ym_older;

DROP TABLE public.measurement_ym_y2016m12;

DROP TABLE public.t11;

CREATE TABLE public.t01 (
	c1 integer,
	c2 character varying(40),
	c3 text
);

CREATE TABLE public.t03 (
	c1 integer,
	c2 character varying(40),
	c3 text
)
USING my_method;

CREATE TABLE public.employees OF public.employee_type (
	name WITH OPTIONS NOT NULL,
	salary WITH OPTIONS DEFAULT 1000
)
USING my_method;

ALTER TABLE public.employees
	ADD CONSTRAINT employees_pkey PRIMARY KEY (name);

CREATE TABLE public.measurement_ym_older PARTITION OF public.measurement_year_month
FOR VALUES FROM (MINVALUE, MINVALUE) TO ('2016', '11')
USING my_method;

CREATE TABLE public.measurement_ym_y2016m12 PARTITION OF public.measurement_year_month
FOR VALUES FROM ('2016', '12') TO ('2017', '1');

CREATE TABLE public.t11 (
	c1 integer
)
USING my_method;