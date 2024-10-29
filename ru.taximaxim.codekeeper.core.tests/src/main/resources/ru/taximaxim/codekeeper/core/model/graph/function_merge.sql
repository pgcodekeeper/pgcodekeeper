CREATE TABLE public.t1 (c1 integer, c2 text);

CREATE TABLE public.t2 (c1 integer, c2 text);

CREATE OR REPLACE FUNCTION public.f2(f1 integer) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $$
  select f1 * 5;
$$;

CREATE OR REPLACE FUNCTION public.f2(f1 text) RETURNS integer
    LANGUAGE sql IMMUTABLE
    AS $$
  select 5;
$$;

CREATE OR REPLACE FUNCTION public.f1(f1 integer) RETURNS integer
    LANGUAGE plpgsql IMMUTABLE
    AS $$
begin
  WITH up as (MERGE INTO t1 USING t2 ON t2.c1 = t1.c1 WHEN MATCHED THEN DO NOTHING RETURNING merge_action() AS n)
  SELECT count(*) FROM up
  WHERE public.f2(up.n) > 10;
end;$$;