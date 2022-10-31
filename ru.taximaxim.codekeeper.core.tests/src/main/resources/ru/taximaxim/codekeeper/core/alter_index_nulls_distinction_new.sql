CREATE TABLE public.table1(id int);

CREATE INDEX index1 ON public.table1 (id) NULLS NOT DISTINCT;

CREATE TABLE public.table2(id int);

CREATE INDEX index2 ON public.table2 (id) NULLS DISTINCT;

CREATE TABLE public.table3(id int);

CREATE INDEX index3 ON public.table3 (id) NULLS DISTINCT;