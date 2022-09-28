CREATE TYPE public.tt AS (c1 integer, c2 integer);

CREATE OR REPLACE FUNCTION public.tt(smallint) RETURNS public.tt
    LANGUAGE plpgsql
    AS $_$
begin
  return ($1::integer, 0)::public.tt;
end;
$_$;

CREATE OR REPLACE FUNCTION public.ttt(smallint) RETURNS public.tt
    LANGUAGE plpgsql
    AS $_$
begin
  return ($1::integer, 0)::public.tt;
end;
$_$;

CREATE CAST (integer AS public.tt) WITHOUT FUNCTION AS IMPLICIT;
CREATE CAST (bigint AS public.tt) WITH INOUT AS ASSIGNMENT;
CREATE CAST (smallint AS public.tt) WITH FUNCTION public.tt(smallint);
CREATE CAST (double precision AS public.tt) WITHOUT FUNCTION;