SET search_path = pg_catalog;

CREATE OPERATOR public.||++ (
	PROCEDURE = tester.nonull_append_strings,
	LEFTARG = text,
	RIGHTARG = text,
	COMMUTATOR = OPERATOR(tester2.||+++),
	NEGATOR = OPERATOR(tester2.||+-+),
	MERGES,
	HASHES,
	RESTRICT = neqsel,
	JOIN = neqjoinsel
);

ALTER OPERATOR public.||++(text, text) OWNER TO shamsutdinov_lr;

COMMENT ON OPERATOR public.||++(text, text) IS 'Тестовый комментарий';