CREATE FUNCTION public.f2(_id_base text, _number anyelement, _need_confirm integer) RETURNS anyelement
  LANGUAGE plpgsql
  AS $_$ begin return _number; end;$_$;

CREATE VIEW public.testview6 AS
  SELECT * FROM public.f2(null, '123', 1);

CREATE VIEW public.testview7 AS
  SELECT * FROM public.f2('text', 90, 3::anyelement);

CREATE VIEW public.testview8 AS
  SELECT * FROM public.f2(123, null, 'no match test');