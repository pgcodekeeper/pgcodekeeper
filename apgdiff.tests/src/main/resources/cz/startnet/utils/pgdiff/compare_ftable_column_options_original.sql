CREATE FOREIGN TABLE public.mytable (
    c1 integer OPTIONS (column_name 'c1') CHECK (c1 > 0)
)
SERVER myserver;
