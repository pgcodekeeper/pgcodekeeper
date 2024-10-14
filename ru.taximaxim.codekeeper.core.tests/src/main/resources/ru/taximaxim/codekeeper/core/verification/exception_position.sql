CREATE OR REPLACE FUNCTION test.exc() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin
EXCEPTION
  WHEN OTHERS THEN get stacked diagnostics
     _sqlstate = returned_sqlstate,
     _message_text = message_text,
     _context = pg_exception_context;
    raise exception 'got exception: state: %, message: %, context: %', _sqlstate, _message_text,_context;
end;
$$;