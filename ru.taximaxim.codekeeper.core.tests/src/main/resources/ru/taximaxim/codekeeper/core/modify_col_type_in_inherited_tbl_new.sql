CREATE TABLE public.a (
    name text,
    population double precision,
    altitude text,
    description integer DEFAULT 555777
);


CREATE TABLE public.a1 (
    state character(2)
)
INHERITS (public.a);

ALTER TABLE ONLY public.a1 ALTER COLUMN description SET DEFAULT 555777;


CREATE TABLE public.a2 (
    altitude text,
    backup text
)
INHERITS (public.a1);

ALTER TABLE ONLY public.a2 ALTER COLUMN description SET DEFAULT 555777;
