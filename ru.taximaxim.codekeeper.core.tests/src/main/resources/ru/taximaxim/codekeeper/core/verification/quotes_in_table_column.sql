CREATE OR REPLACE FUNCTION public.create_table() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin

  CREATE TEMP TABLE films (
    code        char(5),
    "title"      varchar(40),
    did         integer,
    date_prod   date,
    kind        varchar(10),
    "len"       interval hour to minute,
    CONSTRAINT code_title PRIMARY KEY(code,title)
  );
end;
$$;