CREATE TABLE public.t1 (c1 integer, c2 text);

CREATE VIEW public.v1 AS
SELECT c1, c2 FROM public.t1
WHERE (c1 <> 0) AND c2 = 'text'::text;;