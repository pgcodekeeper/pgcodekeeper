CREATE TABLE public.test_1(
    c1 integer DEFAULT 12
);

CREATE TABLE public.test_2(
    c1 integer DEFAULT 21
) INHERITS (public.test_1);
