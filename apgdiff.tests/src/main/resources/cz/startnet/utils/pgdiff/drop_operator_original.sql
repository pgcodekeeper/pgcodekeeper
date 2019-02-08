CREATE OR REPLACE FUNCTION public.nonull_append_strings(text, text) RETURNS boolean
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 IS NULL THEN FALSE
            WHEN $2 IS NULL THEN FALSE
            ELSE TRUE
            END;
    $_$;

CREATE OPERATOR public.||++ (
    PROCEDURE = public.nonull_append_strings,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = OPERATOR(public.||+++),
    NEGATOR = OPERATOR(public.||+-+),
    MERGES,
    HASHES,
    RESTRICT = neqsel,
    JOIN = neqjoinsel
);