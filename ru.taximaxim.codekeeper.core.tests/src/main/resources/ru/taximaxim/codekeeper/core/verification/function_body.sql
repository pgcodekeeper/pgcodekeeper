CREATE OR REPLACE FUNCTION public.f_inline_full() RETURNS void
    LANGUAGE sql 
    BEGIN ATOMIC
  SELECT t.c2 FROM t1 t
    LIMIT 1;
      SELECT t.c2 FROM t1 t
    LIMIT 1;
      SELECT t.c2 FROM t1 t
    LIMIT 1;
END