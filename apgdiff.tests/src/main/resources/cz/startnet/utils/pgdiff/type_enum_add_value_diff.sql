SET search_path = public, pg_catalog;

ALTER TYPE typ_enum
	ADD VALUE 'e-1' BEFORE 'e1';

ALTER TYPE typ_enum
	ADD VALUE 'e0' AFTER 'e-1';

ALTER TYPE typ_enum
	ADD VALUE 'e2.5' AFTER 'e2';
