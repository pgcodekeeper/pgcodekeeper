CREATE TABLE public.t0 (
    c1 integer DEFAULT nextval('public.s1'::regclass) NOT NULL,
    c2 integer DEFAULT public.f1('t', 2),
    c3 integer DEFAULT public.f2(1, 2),
    c4 public.type_tt
);
