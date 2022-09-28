SET search_path = pg_catalog;

ALTER OPERATOR public.||++(text, text)
	SET (RESTRICT = NONE, JOIN = eqjoinsel);