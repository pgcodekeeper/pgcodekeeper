-- here Windows line separator '\r\n'
CREATE OR REPLACE FUNCTION public.func(INOUT _id integer, _name text, _id_parent integer = NULL::integer, _deleted integer = 0, _description text = NULL::text) RETURNS integer
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
declare
  _procname text := 'public.func';
begin
  if _id is null then
    insert into public.table (c_name, id_parent, c_deleted, c_description)
      values (_name, _id_parent, _deleted, _description)
        returning id into _id;
  else
    update public.table
      set c_name = _name,
        id_parent = _id_parent,
        c_deleted = _deleted,
        c_description = _description
        where id = _id;
  end if;
end;
$$;