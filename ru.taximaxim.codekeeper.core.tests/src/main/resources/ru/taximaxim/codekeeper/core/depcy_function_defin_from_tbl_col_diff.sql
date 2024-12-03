SET search_path = pg_catalog;

-- DEPCY: This FUNCTION double_salary_2 depends on the COLUMN: public.emp.salary

DROP FUNCTION public.double_salary_2(nnaammee public.emp);

-- DEPCY: This FUNCTION double_salary depends on the COLUMN: public.emp.salary

DROP FUNCTION public.double_salary(public.emp);

ALTER TABLE public.emp
	ALTER COLUMN salary TYPE integer USING salary::integer; /* TYPE change - table: public.emp original: numeric new: integer */

CREATE OR REPLACE FUNCTION public.double_salary_2(nnaammee public.emp) RETURNS numeric
    LANGUAGE sql
    AS $$
    SELECT (nnaammee.salary * 2)::numeric AS salary;
$$;

ALTER FUNCTION public.double_salary_2(nnaammee public.emp) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION public.double_salary(public.emp) RETURNS numeric
    LANGUAGE sql
    AS $_$
    SELECT ($1.salary * 2)::numeric AS salary;
$_$;

ALTER FUNCTION public.double_salary(public.emp) OWNER TO shamsutdinov_lr;