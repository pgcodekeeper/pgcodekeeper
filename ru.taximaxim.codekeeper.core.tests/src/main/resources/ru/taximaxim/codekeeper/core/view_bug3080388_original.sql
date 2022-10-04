create table public.t ( pk serial primary key, t text default '' );
create view public.v as select * from public.t;
alter view public.v alter column t set default '';
