--no args overload
CREATE FUNCTION public.f1( ) RETURNS bigint
  LANGUAGE plpgsql
  AS $_$ begin RETURN 1; end;$_$;
CREATE VIEW public.testview0 AS
  SELECT * FROM public.f1();

CREATE FUNCTION public.f1( id text, n integer) RETURNS integer
  LANGUAGE plpgsql
  AS $_$ begin RETURN 1; end;$_$;
--Using Positional Notation
CREATE VIEW public.testview1 AS
  SELECT * FROM public.f1(' ', 2);
--Using Named Notation
--older syntax 
CREATE VIEW public.testview2 AS
  SELECT * FROM public.f1(id:= ' ', n := 2);
--new syntax 
CREATE VIEW public.testview3 AS
  SELECT * FROM public.f1(id => ' ', n => 2);

CREATE VIEW public.testview4 AS
  SELECT * FROM public.f1(n := 2, id:= '');
  
--overload
CREATE FUNCTION public.f1(a boolean, id text, n integer,
p timestamp with time zone DEFAULT '2022-12-31 23:59:59'::timestamp with time zone) RETURNS smallint
  LANGUAGE plpgsql
  AS $_$ begin RETURN NULL; end;$_$;
--Using Mixed Notation
--explicit default
CREATE VIEW public.testview5 AS
  SELECT * FROM public.f1(TRUE, p => '2023-01-01 00:00:00'::timestamp with time zone, id => ' ', n => 2);

--Using Mixed Notation with default
CREATE VIEW public.testview6 AS
  SELECT * FROM public.f1(TRUE, id => ' ', n => 2);
  
CREATE FUNCTION public.f12Max(
b1 boolean,
t2 text,
n3 integer,
p4 point ,
b5 boolean,
t6 text,
n7 integer,
p8 point ,
b9 boolean DEFAULT FALSE,
t10 text DEFAULT ' ',
n11 integer DEFAULT 11,
p12 point DEFAULT '(1,2)'::point) RETURNS integer
  LANGUAGE plpgsql
  AS $_$ begin RETURN NULL; end;$_$;
  
CREATE VIEW public.testview7 AS
  SELECT * FROM public.f12Max(TRUE, ' ', 2, '(1,2)'::point, n7 => 7, p8 => '(1,2)'::point, t6 => 'six', b5 => False, p12 => '(1,2)'::point, t10 => '', n11 => 11);
  
CREATE FUNCTION public.f10Max(n1 integer,n2 integer,n3 integer,n4 integer,n5 integer,n6 integer,n7 integer,n8 integer,n9 integer,n10 integer) RETURNS integer
  LANGUAGE plpgsql
  AS $_$ begin RETURN NULL; end;$_$;
  
CREATE VIEW public.testview8 AS
  SELECT * FROM public.f10Max(1,2,3,4,5,6,7,8,n10 := 9, n9 := 10);

