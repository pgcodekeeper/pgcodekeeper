CREATE TABLE public.t1 (
    c1 integer,
    c2 integer,
    c3 integer
);

CREATE TABLE public.t2 (
    c1 integer,
    c2 integer,
    c3 integer
);

CREATE OR REPLACE FUNCTION public.f1(s integer, k integer = 43) RETURNS integer
    LANGUAGE plpgsql
    AS $$ begin SELECT count(t.c1) from public.t1 t where c1 = s ; end $$;

CREATE OR REPLACE FUNCTION public.f_inline_short() RETURNS void
    LANGUAGE sql
    RETURN (SELECT t.c1 FROM public.t1 t LIMIT 1);

CREATE OR REPLACE FUNCTION public.f_inline_full() RETURNS void
    LANGUAGE sql
    BEGIN ATOMIC
 SELECT t.c2 FROM public.t2 t LIMIT 1;
END;

CREATE OR REPLACE FUNCTION public.func_1(_two jsonb) RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
DECLARE
  _id int;
  _t record;
BEGIN
  for _t in
    select distinct
      (n ->> 'name')::text as _name
    from jsonb_array_elements((_two->>'names')::jsonb) n
  loop
    _id_company = public.func_2(null, _t._name);
  end loop;
  for _t in
    select distinct
      (n ->> 'name')::integer as _name
    from jsonb_array_elements((_two->>'names')::jsonb) n
  loop
    _id_company = public.func_3(null, _t._name);
  end loop;
-- not valid part just for test the scope of visiable
  _id_company = public.func_2(null, _t._name);
END;
$$;

CREATE OR REPLACE FUNCTION public.func_2(_first integer, _second text) RETURNS Integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
	RETURN 1;
END;
$$;

CREATE OR REPLACE FUNCTION public.func_2(_first integer, _second integer) RETURNS Integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
	RETURN 1;
END;
$$;

CREATE OR REPLACE FUNCTION public.func_3(_first integer, _second text) RETURNS Integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
	RETURN 1;
END;
$$;

CREATE OR REPLACE FUNCTION public.func_3(_first integer, _second integer) RETURNS Integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
	RETURN 1;
END;
$$;