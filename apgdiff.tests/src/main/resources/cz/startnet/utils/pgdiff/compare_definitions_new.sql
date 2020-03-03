CREATE TABLE public.t1 (c1 integer, c2 text);

create view public.v1 as
select
    c1,
    c2
from
    public.t1
where
    (   c1 <> 0  )
    and 
    c2 = 'text'::text;