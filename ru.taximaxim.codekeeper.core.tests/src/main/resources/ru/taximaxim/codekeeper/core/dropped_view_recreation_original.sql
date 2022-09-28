CREATE TABLE public.t2 (
    t2_c1 character(1),
    c_seq integer NOT NULL
);

CREATE VIEW public.v3 AS
 SELECT a.t2_c1
   FROM public.t2 a;

CREATE VIEW public.v3_boo AS
 SELECT a.t2_c1
   FROM public.v3 a;