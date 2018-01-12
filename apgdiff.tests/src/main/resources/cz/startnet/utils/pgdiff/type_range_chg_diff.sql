SET search_path = public, pg_catalog;

DROP TYPE typ_range;

CREATE TYPE typ_range AS RANGE (
	subtype = character varying,
	subtype_opclass = date_ops,
	collation = pg_catalog."ru_RU.utf8",
	canonical = daterange_canonical
);

ALTER TYPE typ_range OWNER TO botov_av;
