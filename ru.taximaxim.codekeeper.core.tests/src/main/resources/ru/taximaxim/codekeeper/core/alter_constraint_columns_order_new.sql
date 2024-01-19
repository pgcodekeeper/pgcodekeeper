CREATE TABLE public.t1 (
    a circle,
    b circle
);

ALTER TABLE public.t1
	ADD CONSTRAINT c1 EXCLUDE USING gist (b WITH &&, a WITH &&);