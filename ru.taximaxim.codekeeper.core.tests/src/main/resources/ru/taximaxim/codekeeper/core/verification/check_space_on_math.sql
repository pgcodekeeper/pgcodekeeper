CREATE OR REPLACE FUNCTION public.check_math() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
begin
a+a = a + b * (x - y);
a = a::test / 0.5 - f(x, y);
a=a+ b*(x -y);
a=a::test;
perform public.func1(NULL::integer, some_text->'text'->>'from', param1 := par);
SELECT count(*) AS count FROM public.t_files;
select f.* into _sum, _curr, _id_place;
select *, 1 as first from public.t_files;
end;
$$;