CREATE TABLE public.t1 (
    c1 boolean,
    c2 boolean
);

CREATE VIEW public.v1 AS
  SELECT c1 FROM public.t1;