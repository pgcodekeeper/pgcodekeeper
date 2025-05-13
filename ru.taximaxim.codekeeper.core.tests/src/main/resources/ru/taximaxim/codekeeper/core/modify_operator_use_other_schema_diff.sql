SET search_path = pg_catalog;

-- DEPCY: This OPERATOR ||++ depends on the FUNCTION: tester.nonull_append_strings(text, text)

DROP OPERATOR public.||++(text, text);

DROP FUNCTION tester.nonull_append_strings(text, text);

CREATE OR REPLACE FUNCTION tester.nonull_append_strings(text, text) RETURNS text
    LANGUAGE sql IMMUTABLE
    AS $_$
    SELECT CASE WHEN $1 IS NULL THEN FALSE
            WHEN $2 IS NULL THEN FALSE
            ELSE TRUE
            END;
    $_$;

ALTER FUNCTION tester.nonull_append_strings(text, text) OWNER TO shamsutdinov_lr;

CREATE OPERATOR public.||++ (
	PROCEDURE = tester.nonull_append_strings,
	LEFTARG = text,
	RIGHTARG = text,
	COMMUTATOR = OPERATOR(public.||+++),
	NEGATOR = OPERATOR(public.||+-+),
	MERGES,
	HASHES,
	RESTRICT = neqsel,
	JOIN = neqjoinsel
);

ALTER OPERATOR public.||++(text, text) OWNER TO shamsutdinov_lr;

COMMENT ON OPERATOR public.||++(text, text) IS 'Тестовый комментарий';