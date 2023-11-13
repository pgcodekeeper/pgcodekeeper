CREATE TABLE public.t1 (
    id bigint PRIMARY KEY DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE public.t2 (
    id bigint REFERENCES public.t1(id) DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE public.t3 (
    id bigint
);

ALTER TABLE public.t3
    ADD CONSTRAINT t3_fk_1 FOREIGN KEY (id) REFERENCES public.t1;

CREATE TABLE public.t4 (
    id bigint REFERENCES public.t1(id) DEFERRABLE
);

CREATE TABLE public.t5 (
    id bigint REFERENCES public.t1(id) DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE public.t6 (
    id bigint REFERENCES public.t1(id) DEFERRABLE INITIALLY DEFERRED
);