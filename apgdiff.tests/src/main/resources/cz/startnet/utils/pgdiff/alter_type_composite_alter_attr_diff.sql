SET search_path = public, pg_catalog;

ALTER TYPE typ_composite
	ALTER ATTRIBUTE key TYPE character varying(80) COLLATE pg_catalog."ru_RU", 
	ALTER ATTRIBUTE val TYPE text COLLATE pg_catalog."en_GB.utf8";
