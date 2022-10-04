SET search_path = pg_catalog;

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

ALTER OPERATOR public.||++(text, text) OWNER TO shamsutdinov_lr;

COMMENT ON OPERATOR public.||++(text, text) IS 'Тестовый комментарий';

CREATE OPERATOR public.||++ (
	PROCEDURE = public.nonull_append_integer,
	LEFTARG = integer,
	RIGHTARG = integer
);

ALTER OPERATOR public.||++(integer, integer) OWNER TO shamsutdinov_lr;