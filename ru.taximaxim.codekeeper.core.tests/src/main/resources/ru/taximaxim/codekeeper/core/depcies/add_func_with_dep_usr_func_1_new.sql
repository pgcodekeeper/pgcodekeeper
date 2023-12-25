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