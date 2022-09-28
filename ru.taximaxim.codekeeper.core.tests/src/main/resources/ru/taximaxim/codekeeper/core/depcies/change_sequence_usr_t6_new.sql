CREATE TABLE public.t6 (
    c2 text,
    c1 integer DEFAULT nextval('public.s6'::regclass) NOT NULL,
    c3 integer DEFAULT public.fff(1, 2)
);