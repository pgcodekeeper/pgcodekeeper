SET search_path = pg_catalog;

-- DEPCY: This FUNCTION func_3 is a dependency of FUNCTION: public.func_1(jsonb)

CREATE OR REPLACE FUNCTION public.func_3(_first integer, _second integer) RETURNS Integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
	RETURN 1;
END;
$$;

-- DEPCY: This FUNCTION func_2 is a dependency of FUNCTION: public.func_1(jsonb)

CREATE OR REPLACE FUNCTION public.func_2(_first integer, _second text) RETURNS Integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
BEGIN
	RETURN 1;
END;
$$;

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