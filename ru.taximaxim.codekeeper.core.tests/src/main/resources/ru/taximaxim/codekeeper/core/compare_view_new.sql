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