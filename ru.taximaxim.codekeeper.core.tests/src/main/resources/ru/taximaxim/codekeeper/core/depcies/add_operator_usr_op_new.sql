CREATE OPERATOR public.> (
    PROCEDURE = public.compare,
    LEFTARG = integer,
    RIGHTARG = integer
);