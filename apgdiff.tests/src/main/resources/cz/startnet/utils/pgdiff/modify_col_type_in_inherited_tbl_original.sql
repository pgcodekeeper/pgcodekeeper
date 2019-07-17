CREATE TABLE public.a (
    name text,
    population double precision,
    altitude text,
    description text DEFAULT 'info'::text
);


CREATE TABLE public.a1 (
    state character(2)
)
INHERITS (public.a);

ALTER TABLE ONLY public.a1 ALTER COLUMN description SET DEFAULT 'info'::text;


CREATE TABLE public.a2 (
    altitude text,
    backup text
)
INHERITS (public.a1);

ALTER TABLE ONLY public.a2 ALTER COLUMN description SET DEFAULT 'info'::text;
