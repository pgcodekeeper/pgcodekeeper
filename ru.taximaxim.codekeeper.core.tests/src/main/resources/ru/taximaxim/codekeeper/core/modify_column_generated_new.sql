CREATE TABLE public.people (
    height_cm numeric,
    height_in numeric GENERATED ALWAYS AS (height_cm / 4.32) STORED
);