CREATE FOREIGN TABLE public.mytable (
    c1 integer
)
SERVER myserver;

ALTER FOREIGN TABLE public.mytable ALTER COLUMN c1 OPTIONS (column_name 'c1');

ALTER TABLE public.mytable
    ADD CONSTRAINT mytable_c1_check CHECK ((c1 > 0));