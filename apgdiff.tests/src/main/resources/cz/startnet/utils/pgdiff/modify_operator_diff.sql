SET search_path = pg_catalog;

DROP OPERATOR public.||++(text, text);

CREATE OPERATOR public.||++ (
	PROCEDURE = public.nonull_append_strings,
	LEFTARG = text,
	RIGHTARG = text,
	COMMUTATOR = OPERATOR(public.||+-+),
	NEGATOR = OPERATOR(public.||+++),
	MERGES
);

ALTER OPERATOR public.||++(text, text) OWNER TO shamsutdinov_lr;

COMMENT ON OPERATOR public.||++(text, text) IS 'Тестовый комментарий';