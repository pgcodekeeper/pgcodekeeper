SET search_path = pg_catalog;

ALTER TYPE public.typ_composite
	ALTER ATTRIBUTE key TYPE character varying(80) COLLATE pg_catalog."ru_RU",
	ALTER ATTRIBUTE "Val" TYPE text COLLATE pg_catalog."en_GB.utf8";
